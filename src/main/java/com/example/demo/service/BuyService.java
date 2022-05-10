package com.example.demo.service;

import com.example.demo.dto.BuyDto;
import com.example.demo.dto.PurchaseDto;

import java.security.Principal;

public interface BuyService {

    PurchaseDto buy(BuyDto buyDto, Principal principal);
}
