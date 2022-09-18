package com.example.sampleservice.controllers;

import com.example.jwtsecurityautoconfigure.JWTSecurityUtil;
import com.example.jwtsecurityautoconfigure.JWTUserInfo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/samples")
public class SampleController {

    @GetMapping("/test")
    public String test() {
        return "Test!";
    }

    @GetMapping("/user-info")
    public JWTUserInfo retrieveUserInfo() {
        return JWTSecurityUtil.getJWTUserInfo().orElse(null);
    }

}
