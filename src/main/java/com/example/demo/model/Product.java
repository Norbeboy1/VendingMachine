package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @Entity @Table(name = "Product")
public class Product {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int amountAvailable;
    private int cost;
    @Column(name = "product_name", unique = true)
    private String productName;
    private String sellerName;
}
