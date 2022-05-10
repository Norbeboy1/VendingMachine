package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Getter @Setter
public class PurchaseDto {
    @PositiveOrZero
    private int totalCost;
    @NotEmpty
    private ProductDto productDto;
    @NotEmpty
    private int change;
}
