package com.example.demo.dto;

import com.example.demo.validator.CostConstraint;
import com.example.demo.validator.ProductCostConstraint;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DepositDto {

    @CostConstraint
    private int coin;
    @ProductCostConstraint
    private int totalCoins;
}
