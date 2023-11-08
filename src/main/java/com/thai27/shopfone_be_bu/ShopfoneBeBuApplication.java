package com.thai27.shopfone_be_bu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class ShopfoneBeBuApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopfoneBeBuApplication.class, args);
    }

    @Bean
    BCryptPasswordEncoder passencode() {
        ;
        return new BCryptPasswordEncoder();
    }

}
