package com.seguridadindustrial.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Backend {
    public static void main(String[] args) {
        SpringApplication.run(Backend.class, args);
        System.out.println("✅ Backend de Seguridad Industrial ejecutándose en puerto 8081");
    }
}