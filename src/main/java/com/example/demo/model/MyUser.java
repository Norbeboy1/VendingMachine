package com.example.demo.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter @Entity @Table(name = "myuser")
public class MyUser {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "username", unique = true)
    private String username;
    private String password;
    private String roles;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "deposit_id", referencedColumnName = "id")
    private Deposit deposit;
}
