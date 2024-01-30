package com.example.LAB2.Backend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@ComponentScan
public class Config {
    @Bean
    RestClient getRestClient() {
        return RestClient.builder().build();
    }
}
