package com.example.jwtsecurityautoconfigure;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

@Component("jwtAuthenticationManager")
@RequiredArgsConstructor
public class JWTAuthenticationManager implements AuthenticationManager {

    private final ObjectMapper objectMapper;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        var principal = (String) authentication.getPrincipal();
        var jwtToken = principal.replace("Bearer ", "");
        var decodedJWT = JWT.decode(jwtToken);
        return extractTokenAndPopulateAuthority(authentication, decodedJWT);
    }

    public UsernamePasswordAuthenticationToken extractTokenAndPopulateAuthority(Authentication authentication,
                                                                                DecodedJWT decodedJWT) {
        var userInfo = populateJWTUserInfo(decodedJWT);
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.addAll(authentication.getAuthorities());
        authorities.addAll(populateAuthorities(decodedJWT));
        var authenticatedToken = new UsernamePasswordAuthenticationToken(
                decodedJWT.getSubject(),
                decodedJWT.getToken(),
                authorities);
        authenticatedToken.setDetails(userInfo);
        return authenticatedToken;

    }

    @SneakyThrows
    public JWTUserInfo populateJWTUserInfo(DecodedJWT decodedJWT) {
        var payload = new String(Base64.getDecoder().decode(decodedJWT.getPayload()));
        return objectMapper.readValue(payload, JWTUserInfo.class);
    }

    public List<SimpleGrantedAuthority> populateAuthorities(DecodedJWT decodedJWT) {
        var roleClaim = decodedJWT.getClaim("role");
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (roleClaim.as(Object.class) instanceof List) {
            authorities.addAll(roleClaim.asList(SimpleGrantedAuthority.class));
        } else {
            authorities.add(roleClaim.as(SimpleGrantedAuthority.class));
        }
        return authorities;
    }
}
