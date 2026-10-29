package com.example.demo.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentBeanExample {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext()) {
            context.register(GreetingService.class);
            context.refresh();

            GreetingService service = context.getBean(GreetingService.class);
            System.out.println(service.greet("Spring learner"));
        }
    }
}