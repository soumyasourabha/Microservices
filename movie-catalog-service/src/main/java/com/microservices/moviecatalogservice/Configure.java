package com.microservices.moviecatalogservice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class Configure {
    @Bean
    public RestTemplate getrestTemplate() {

        return new RestTemplate();
    }

    @Bean
    public WebClient.Builder getWebClientBuilder() {

        return WebClient.builder();
    }
}
