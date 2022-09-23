package com.example.resttemplateautoconfigure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
}
