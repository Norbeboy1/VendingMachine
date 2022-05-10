package com.example.demo.service;

import com.example.demo.dto.MyUserDto;

import java.security.Principal;

public interface MyUserService {

    /** returns a user from db */
    MyUserDto getMyUser(Principal principal);

    /** adds a user in db */
    void addMyUser(MyUserDto myUserDto);

    /** deletes a user in db */
    void deleteMyUser(Principal principal);
}
