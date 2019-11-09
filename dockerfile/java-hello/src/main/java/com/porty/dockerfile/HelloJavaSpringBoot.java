package com.porty.dockerfile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/** Простейший HTTP сервис Java с использованием Spring Boot */
@SpringBootApplication
public class HelloJavaSpringBoot {
    // запускает стандартный сервер Jetty, порт 8080
    public static void main(String[] args) {
        SpringApplication.run(HelloJavaSpringBoot.class);
    }


    @RestController
    public static final class HelloWorldController {
        // обрабатываем запрос к корневому пути /
        @GetMapping("/")
        public String helloWorld() {
            return "Привет, это Java Spring Boot из контейнера!";
        }
    }
}