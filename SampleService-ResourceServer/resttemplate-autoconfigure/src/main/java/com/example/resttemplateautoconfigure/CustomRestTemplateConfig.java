package com.example.resttemplateautoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

@Configuration
@Import(RestTemplateConfig.class)
public class CustomRestTemplateConfig {

    @Bean("coreESTestTemplate")
    public RestTemplate coreESRestTemplate(RestTemplate restTemplate) {
        return restTemplate;
    }

    @Bean("hiESTestTemplate")
    public RestTemplate hiESRestTemplate(RestTemplate restTemplate) {
        return restTemplate;
    }
}
