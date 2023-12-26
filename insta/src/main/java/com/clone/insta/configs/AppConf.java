package com.clone.insta.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Configuration
@EnableWebSecurity
public class AppConf {

    static final String signInUrl = "/sign-in";
    static final String entryUrl = "/";
    static final String[] publicUlrls = {
            entryUrl
            , "/favicon.ico"
            , "images/*"
    };
    static final String[] signUrls = {
        signInUrl
    };

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        
         http
            .cors(cors->cors.disable())
            .csrf(csrf->csrf.disable())
            .authorizeHttpRequests(custom->{
                try {
                    custom
                        .requestMatchers(publicUlrls).permitAll()
                        .requestMatchers(signUrls).permitAll()
                        .anyRequest().authenticated()
                    ;                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            })
            .exceptionHandling(custom->{
                custom.authenticationEntryPoint(
                    new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)
                );
            })
            .logout(custom->{
                custom.logoutSuccessUrl("/main");
            })
            .oauth2Login(custom->{
                custom.loginPage(signInUrl);
            })
            ;
        return http.build();
    }
}
