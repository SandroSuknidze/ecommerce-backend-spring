package com.sandro.ecommercebackendspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class EcommerceBackendSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommerceBackendSpringApplication.class, args);
    }

}
