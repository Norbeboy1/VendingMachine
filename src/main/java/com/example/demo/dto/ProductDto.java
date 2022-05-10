package com.example.demo.dto;

import com.example.demo.validator.ProductCostConstraint;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class ProductDto {
    @PositiveOrZero
    private int amountAvailable;
    @ProductCostConstraint
    private int cost;
    @NotEmpty
    private String productName;
    @NotEmpty
    private String sellerName;
}
