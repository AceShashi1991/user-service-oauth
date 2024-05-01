package com.scaler.userserviceoauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class UserServiceOauthApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserServiceOauthApplication.class, args);
    }

}
