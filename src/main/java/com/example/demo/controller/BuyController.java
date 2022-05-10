package com.example.demo.controller;

import com.example.demo.dto.BuyDto;
import com.example.demo.dto.PurchaseDto;
import com.example.demo.service.impl.BuyServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController @AllArgsConstructor @RequestMapping("/buy")
public class BuyController {
    private final BuyServiceImpl buyService;

    @GetMapping
    public PurchaseDto buy(@RequestBody BuyDto buyDto, Principal principal){
        return buyService.buy(buyDto, principal);
    }
}
