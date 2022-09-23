package com.example.basicauthsecurityautoconfigure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "basic-auth-security")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasicAuthSecurityProperties {

    private String username;
    private String password;

    private String[] publicPaths;
}
