package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class BuyDto {
    @NotEmpty
    private int amountOfProducts;
    @NotEmpty
    private Long productId;
}
