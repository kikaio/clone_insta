package com.clone.insta.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

import com.clone.insta.services.CustomOAuthService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
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

    private final CustomOAuthService customOAuthService;

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
            .logout(custom->{
                custom.logoutSuccessUrl("/main");
            })
            .formLogin(custom->{
                custom.loginPage("/sign-in");
            })
            .oauth2Login(custom->{
                custom.loginPage(signInUrl);
                custom.userInfoEndpoint(conf->{
                    conf.userService(customOAuthService);
                });
            })
            ;
        return http.build();
    }
}
