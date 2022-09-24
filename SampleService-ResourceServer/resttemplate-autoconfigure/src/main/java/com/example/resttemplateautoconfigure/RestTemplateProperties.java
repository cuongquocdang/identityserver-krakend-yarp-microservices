package com.example.resttemplateautoconfigure;

import lombok.*;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "rest-template")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestTemplateProperties {

    private int maximumTotalPool;
    private int maximumPerRoutePool;
    private int connectionRequestTimeout;
    private int socketTimeout;
    private int connectTimeout;

    private ServiceProperties coreService;

    @Data
    public static class ServiceProperties {

        private Credentials credentials;
    }

    @Data
    public static class Credentials {

        private String username;
        private String password;
    }
}
