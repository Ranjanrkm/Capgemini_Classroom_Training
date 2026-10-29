package com.example.demo.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanScopeExample {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(ScopeConfiguration.class)) {
            SingletonBean firstSingleton = context.getBean(SingletonBean.class);
            SingletonBean secondSingleton = context.getBean(SingletonBean.class);

            PrototypeBean firstPrototype = context.getBean(PrototypeBean.class);
            PrototypeBean secondPrototype = context.getBean(PrototypeBean.class);

            System.out.println("Singleton objects are the same: "
                    + (firstSingleton == secondSingleton));
            System.out.println("Prototype objects are the same: "
                    + (firstPrototype == secondPrototype));
        }
    }
}