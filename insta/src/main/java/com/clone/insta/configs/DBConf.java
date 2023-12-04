package com.clone.insta.configs;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class DBConf {
    
    @Value("${spring.datasource.username}")
    private String username;
    
    @Value("${spring.datasource.password}")
    private String password;
    
    @Value("${spring.jpa.database}")
    private String db;

    @PostConstruct
    public void postConstructor()
    {
        log.info("username:[%s], password:[%s]".formatted(username, password));
    }
}
