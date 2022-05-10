package com.example.demo.exception;

public class MyUserNotFoundException extends RuntimeException{
    public MyUserNotFoundException(String name){
        System.out.println("User with name " + name + " not found");
    }
}
