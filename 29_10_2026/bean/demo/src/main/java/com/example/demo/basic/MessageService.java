package com.example.demo.basic;

import org.springframework.stereotype.Component;

@Component
public class MessageService {

    private final MessageRepository repository;

    public MessageService(MessageRepository repository) {
        this.repository = repository;
    }

    public String getMessage() {
        return repository.findMessage();
    }
}