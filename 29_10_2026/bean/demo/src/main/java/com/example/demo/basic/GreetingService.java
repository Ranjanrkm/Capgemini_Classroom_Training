package com.example.demo.basic;

import org.springframework.stereotype.Component;

@Component
public class GreetingService {

    public String greet(String name) {
        return "Welcome, " + name + "!";
    }
}