package com.example.jwtsecurityautoconfigure;

import lombok.experimental.UtilityClass;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@UtilityClass
@SuppressWarnings("unused")
public class JWTSecurityUtil {

    public static Optional<JWTUserInfo> getJWTUserInfo() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        if (null == authentication || null == authentication.getDetails()) {
            return Optional.empty();
        }
        if (SecurityContextHolder.getContext().getAuthentication().getDetails() instanceof JWTUserInfo jwtUserInfo) {
            return Optional.of(jwtUserInfo);
        }
        return Optional.empty();
    }

}
