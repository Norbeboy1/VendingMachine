package com.example.demo.converter;

import com.example.demo.dto.DepositDto;
import com.example.demo.model.Deposit;
import org.springframework.stereotype.Component;

@Component
public class DepositConverter {

    public DepositDto from(Deposit deposit){
        DepositDto depositDto = new DepositDto();

        depositDto.setCoin(deposit.getCoin());
        depositDto.setTotalCoins(deposit.getTotalCoins());

        return depositDto;
    }

    public Deposit to(DepositDto depositDto){
        Deposit deposit = new Deposit();

        deposit.setCoin(depositDto.getCoin());
        deposit.setTotalCoins(depositDto.getTotalCoins());

        return deposit;
    }
}
