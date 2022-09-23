package com.example.logbookloggingautoconfigure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.zalando.logbook.HttpLogWriter;

@Configuration
public class LogbookLoggingConfig {

    @Bean
    public HttpLogWriter writer() {
        return new CustomHttpLogWriter();
    }

}
