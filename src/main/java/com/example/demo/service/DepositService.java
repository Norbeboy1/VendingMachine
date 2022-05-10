package com.example.demo.service;

import com.example.demo.dto.DepositDto;

import java.security.Principal;

public interface DepositService {
    void addDeposit(Principal principal, DepositDto depositDto);

    void deleteDeposit(Principal principal);

    DepositDto getDepositById(Principal principal);
}
