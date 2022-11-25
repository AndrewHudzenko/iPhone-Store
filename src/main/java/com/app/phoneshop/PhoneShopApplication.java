package com.app.phoneshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PhoneShopApplication {
    public static void main(String[] args) {
        SpringApplication.run(PhoneShopApplication.class, args);
    }
}
