package com.clone.insta.dto;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Scope(scopeName = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Component
@ToString
@Setter
public class SessionDto implements Serializable {
    public static final long serialVersionUID = 1L;

    private String email;
    private String nickname;    
}
