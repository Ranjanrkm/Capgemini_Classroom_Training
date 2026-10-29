package com.example.demo.basic;

import org.springframework.stereotype.Component;

@Component
public class MessageRepository {

    public String findMessage() {
        return "Message loaded by the repository";
    }
}