package com.example.demo.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConstructorInjectionExample {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(MessageRepository.class, MessageService.class);
            context.refresh();

            MessageService service = context.getBean(MessageService.class);
            System.out.println(service.getMessage());
        }
    }
}