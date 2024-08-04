package org.team.translateservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TranslateServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TranslateServiceApplication.class, args);
    }

}
