package com.clone.insta.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppConf {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        String[] publicUlrls = {
            "/"
            , "/favicon.ico"
            , "images/*"
        };
        String[] signUrls = {
            "/sign-in"
        };
        
         http
            .cors(cors->cors.disable())
            .csrf(csrf->csrf.disable())
            .authorizeHttpRequests(custom->{
                custom
                    .requestMatchers(publicUlrls).permitAll()
                    .requestMatchers(signUrls).permitAll()
                    .anyRequest().authenticated()
                ;
            })
            .formLogin(custom->{
                custom.loginPage("/sign-in")
                ;
            })
            ;
        return http.build();
    }
}
