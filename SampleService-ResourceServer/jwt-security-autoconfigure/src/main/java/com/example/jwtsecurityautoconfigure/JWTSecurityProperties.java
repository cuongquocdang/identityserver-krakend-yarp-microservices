package com.example.jwtsecurityautoconfigure;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration("jwtSecurityProperties")
@ConfigurationProperties(prefix = "jwt-security")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class JWTSecurityProperties {

    private String[] publicPaths;
    private String[] authenticatedAuthorities;
}
