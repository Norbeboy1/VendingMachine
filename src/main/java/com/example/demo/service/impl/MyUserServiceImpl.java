package com.example.demo.service.impl;

import com.example.demo.converter.UserConverter;
import com.example.demo.dto.MyUserDto;
import com.example.demo.model.MyUser;
import com.example.demo.repository.MyUserRepository;
import com.example.demo.service.MyUserService;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class MyUserServiceImpl implements MyUserService {
    private final MyUserRepository myUserRepository;
    private final UserConverter userConverter;

    public MyUserServiceImpl(MyUserRepository myUserRepository, UserConverter userConverter) {
        this.myUserRepository = myUserRepository;
        this.userConverter = userConverter;
    }

    @Override
    public MyUserDto getMyUser(Principal principal) {
        return userConverter.from(myUserRepository.findByUsername(principal.getName()).get());
    }

    @Override
    public void addMyUser(MyUserDto myUserDto) {
        MyUser myUser = myUserRepository.findByUsername(myUserDto.getUsername()).orElse(null);
        if(myUser==null)
        myUserRepository.save(userConverter.to(myUserDto));
    }

    @Override
    public void deleteMyUser(Principal principal) {
        myUserRepository.delete(myUserRepository.findByUsername(principal.getName()).get());
    }
}
