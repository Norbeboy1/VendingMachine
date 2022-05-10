package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @Entity @Table(name = "Deposit")
public class Deposit {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int coin;
    private int totalCoins;
    @OneToOne(mappedBy = "deposit")
    private MyUser user;
}
