package com.cubicfox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class CubicfoxApplication {
    public static void main(String[] args) {
        SpringApplication.run(CubicfoxApplication.class, args);
    }
}
