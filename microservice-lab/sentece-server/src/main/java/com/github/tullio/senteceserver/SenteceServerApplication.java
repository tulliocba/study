package com.github.tullio.senteceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SenteceServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SenteceServerApplication.class, args);
    }

}
