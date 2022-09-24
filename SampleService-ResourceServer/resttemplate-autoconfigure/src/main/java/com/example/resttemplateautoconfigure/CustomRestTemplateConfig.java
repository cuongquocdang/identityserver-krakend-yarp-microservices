package com.example.resttemplateautoconfigure;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.web.client.RestTemplate;

@Configuration
@Import(RestTemplateConfig.class)
@RequiredArgsConstructor
public class CustomRestTemplateConfig {

    private final RestTemplateProperties restTemplateProperties;

    @Bean("coreESTestTemplate")
    public RestTemplate coreESRestTemplate(RestTemplate restTemplate) {
        var coreServiceProperties = restTemplateProperties.getCoreService();
        // add basic auth
        var credentials = coreServiceProperties.getCredentials();
        restTemplate.getInterceptors().add(basicAuthInterceptor(credentials.getUsername(), credentials.getPassword()));
        return restTemplate;
    }

    @Bean("hiESTestTemplate")
    public RestTemplate hiESRestTemplate(RestTemplate restTemplate) {
        return restTemplate;
    }

    private ClientHttpRequestInterceptor basicAuthInterceptor(String username, String password) {
        return new BasicAuthenticationInterceptor(username, password);
    }
}
