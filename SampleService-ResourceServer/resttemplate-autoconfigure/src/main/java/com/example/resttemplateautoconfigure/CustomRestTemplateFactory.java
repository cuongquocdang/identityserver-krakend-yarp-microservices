package com.example.resttemplateautoconfigure;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class CustomRestTemplateFactory {

    private final RestTemplate coreESRestTemplate;
    private final RestTemplate hiESRestTemplate;

    public RestTemplate target(TargetExternalSystem targetExternalSystem) {
        return switch (targetExternalSystem) {
            case  CORE_ES -> coreESRestTemplate;
            case HI_ES -> hiESRestTemplate;
        };
    }

}
