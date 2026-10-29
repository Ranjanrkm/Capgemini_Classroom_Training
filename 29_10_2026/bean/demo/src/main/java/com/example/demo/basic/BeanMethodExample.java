package com.example.demo.basic;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class BeanMethodExample {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context =
                     new AnnotationConfigApplicationContext(BeanConfiguration.class)) {
            BasicBean bean = context.getBean(BasicBean.class);
            System.out.println(bean.greet());
        }
    }
}