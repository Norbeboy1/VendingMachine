package com.example.demo.controller;

import com.example.demo.dto.DepositDto;
import com.example.demo.service.impl.DepositServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController @AllArgsConstructor @RequestMapping("/deposit")
public class DepositController {
    private final DepositServiceImpl depositService;

    @PostMapping
    public void addDeposit(Principal principal, @RequestBody DepositDto DepositDto){
        depositService.addDeposit(principal, DepositDto);
    }

    @GetMapping
    public DepositDto getDepositById(Principal principal){
        return depositService.getDepositById(principal);
    }

    @DeleteMapping
    public void deleteDeposit(Principal principal) {
        depositService.deleteDeposit(principal);
    }
}
