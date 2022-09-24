package com.example.sampleservice.configs;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sample-core-service")
@Data
public class SampleCoreServiceProperties {

    private Urls urls;

    @Data
    public static class Urls {
        private String base;
        private String retrievePostsByPostsId;
        private String retrieveAllPosts;
    }
}
