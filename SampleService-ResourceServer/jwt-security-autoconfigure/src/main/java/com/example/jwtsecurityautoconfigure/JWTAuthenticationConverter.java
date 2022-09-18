package com.example.jwtsecurityautoconfigure;

import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationConverter;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Component("jwtAuthenticationConverter")
public class JWTAuthenticationConverter implements AuthenticationConverter {

    @Override
    public Authentication convert(HttpServletRequest request) {
        var authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (null == authorizationHeader) {
            return null;
        }
        return new UsernamePasswordAuthenticationToken(authorizationHeader, null, List.of());
    }
}
