package com.example.basicauthsecurityautoconfigure;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class BasicAuthSecurityConfig {

    private final BasicAuthSecurityAuthenticationProvider basicAuthSecurityAuthenticationProvider;
    private final BasicAuthSecurityProperties basicAuthSecurityProperties;

    @Bean
    @SneakyThrows
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        httpSecurity
                .authenticationProvider(basicAuthSecurityAuthenticationProvider)
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .cors().disable()
                .formLogin().disable()
                .logout().disable()
                .httpBasic() // enabled http basic auth
                .and()
                .authorizeRequests()
                .antMatchers(basicAuthSecurityProperties.getPublicPaths()).permitAll()
                .anyRequest().fullyAuthenticated();

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
