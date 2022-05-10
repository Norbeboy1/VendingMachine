package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class MyUserDto {
    @NotEmpty
    private String username;
    @NotEmpty
    private DepositDto deposit;
    @NotEmpty
    private String roles;
    @NotEmpty
    private String password;
}
