package com.clone.insta.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import jakarta.servlet.DispatcherType;

@Configuration
@EnableWebSecurity
public class AppConf {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception
    {

        String[] publicUrls = {
            ""
            , "/"
            , "/favicon.ico"
        };

         http
            .cors(cors->cors.disable())
            .csrf(csrf->csrf.disable())
            .authorizeHttpRequests(custom->{
                custom
                    .dispatcherTypeMatchers(DispatcherType.FORWARD).permitAll()
                    .requestMatchers(publicUrls).permitAll()
                    .anyRequest().authenticated()
                    ;
            })
            ;
        return http.build();
    }
}
