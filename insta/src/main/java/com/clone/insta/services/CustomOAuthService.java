package com.clone.insta.services;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.clone.insta.dto.OAuthAttr;
import com.clone.insta.dto.SessionDto;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@Service
public class CustomOAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Resource
    private final SessionDto sessionDto;

    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
        var defService = new DefaultOAuth2UserService();
        var oauthUser = defService.loadUser(request);
        
        var regisId = request.getClientRegistration().getRegistrationId();
        var userName = request.getClientRegistration()
            .getProviderDetails()
            .getUserInfoEndpoint()
            .getUserNameAttributeName()
        ;
        var oauthDto = OAuthAttr.from(regisId, userName, oauthUser.getAttributes());
        if(oauthDto == null)
        {
            throw new OAuth2AuthenticationException(new OAuth2Error("not exist provider registration id"));
        }

        sessionDto.setEmail(oauthDto.getEmail());
        sessionDto.setNickname(oauthDto.getName());
        httpSession.setAttribute("sessionDto", sessionDto);

        //do something
        return oauthUser;
    }
}
