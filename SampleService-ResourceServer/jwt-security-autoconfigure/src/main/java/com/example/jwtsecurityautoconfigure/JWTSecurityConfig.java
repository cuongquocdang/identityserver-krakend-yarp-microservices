package com.example.jwtsecurityautoconfigure;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration("jwtSecurityConfig")
@RequiredArgsConstructor
public class JWTSecurityConfig {

    private final JWTAuthenticationManager jwtAuthenticationManager;
    private final JWTAuthenticationConverter jwtAuthenticationConverter;
    private final JWTSecurityProperties jwtSecurityProperties;

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity
                .addFilterBefore(authenticationWebFilter(), BasicAuthenticationFilter.class)
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().disable()
                .httpBasic().disable()
                .formLogin().disable()
                .logout().disable()
                .authorizeRequests()
                .antMatchers(jwtSecurityProperties.getPublicPaths())
                .permitAll()
                .anyRequest()
                .hasAnyAuthority(jwtSecurityProperties.getAuthenticatedAuthorities());
        return httpSecurity.build();
    }

    private AuthenticationFilter authenticationWebFilter() {
        var authenticationFilter = new AuthenticationFilter(jwtAuthenticationManager, jwtAuthenticationConverter);
        authenticationFilter.setSuccessHandler(new JWTAuthenticationSuccessHandler());
        return authenticationFilter;
    }

}
