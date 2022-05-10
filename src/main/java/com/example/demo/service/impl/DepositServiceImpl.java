package com.example.demo.service.impl;

import com.example.demo.converter.DepositConverter;
import com.example.demo.dto.DepositDto;
import com.example.demo.model.Deposit;
import com.example.demo.model.MyUser;
import com.example.demo.repository.MyUserRepository;
import com.example.demo.service.DepositService;
import org.springframework.stereotype.Component;

import java.security.Principal;

@Component
public class DepositServiceImpl implements DepositService {
    private final MyUserRepository myUserRepository;
    private final DepositConverter depositConverter;

    public DepositServiceImpl(MyUserRepository myUserRepository, DepositConverter depositConverter) {
        this.myUserRepository = myUserRepository;
        this.depositConverter = depositConverter;
    }

    @Override
    public void addDeposit(Principal principal, DepositDto depositDto) {
        Deposit deposit = depositConverter.to(depositDto);
        MyUser myUser = myUserRepository.findByUsername(principal.getName()).get();

        if(myUser.getDeposit() == null){
            myUser.setDeposit(deposit);
        }
        else {
            Deposit depositUser = myUser.getDeposit();
            depositUser.setTotalCoins(depositUser.getTotalCoins() + deposit.getCoin());
            myUser.setDeposit(depositUser);
        }
        myUserRepository.save(myUser);
    }

    @Override
    public void deleteDeposit(Principal principal) {
        MyUser myUser = myUserRepository.findByUsername(principal.getName()).get();
        Deposit deposit = myUser.getDeposit();
        deposit.setTotalCoins(0);
        deposit.setCoin(0);
        myUser.setDeposit(deposit);
        myUserRepository.save(myUser);
    }

    @Override
    public DepositDto getDepositById(Principal principal) {
        return depositConverter.from(myUserRepository.findByUsername(principal.getName()).get().getDeposit());
    }
}