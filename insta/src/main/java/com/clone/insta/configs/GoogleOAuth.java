package com.clone.insta.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class GoogleOAuth {
    @Value("${spring.security.oauth2.client.registration.google.client-id:}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String secretKey;

    @PostConstruct
    public void postConstuct()
    {
        log.debug("====google oauth info====");
        log.debug("[client id]".formatted(clientId));
        log.debug("[secret]".formatted(secretKey));
    }
}
