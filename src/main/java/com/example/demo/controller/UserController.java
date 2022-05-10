package com.example.demo.controller;

import com.example.demo.dto.MyUserDto;
import com.example.demo.service.impl.MyUserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController @AllArgsConstructor @RequestMapping("/user")
public class UserController {
    private final MyUserServiceImpl myUserService;

    @PostMapping
    public void addMyUser(@RequestBody MyUserDto myUserDto){
        myUserService.addMyUser(myUserDto);
    }

    @GetMapping
    public MyUserDto getMyUser(Principal principal){
        return myUserService.getMyUser(principal);
    }

    @DeleteMapping
    public void deleteMyUser(Principal principal) {
        myUserService.deleteMyUser(principal);
    }
}
