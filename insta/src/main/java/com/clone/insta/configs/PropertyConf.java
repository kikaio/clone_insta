package com.clone.insta.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class PropertyConf {

    @Value("${spring.profiles.active:local}")
    private String active;

    @PostConstruct
    public void postConstructor()
    {
        log.info("cur active running enviroment : [%s]".formatted(active));
    }
}
