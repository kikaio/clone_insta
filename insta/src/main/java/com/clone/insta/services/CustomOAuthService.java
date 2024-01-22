package com.clone.insta.services;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import com.clone.insta.Entities.InstaUser;
import com.clone.insta.Entities.Profile;
import com.clone.insta.dto.OAuthAttr;
import com.clone.insta.dto.SessionDto;
import com.clone.insta.enums.ERoles;
import com.clone.insta.repositories.InstaUserRepository;
import com.clone.insta.repositories.ProfileRepository;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CustomOAuthService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {

    @Resource
    private final SessionDto sessionDto;

    private final HttpSession httpSession;

    private final InstaUserRepository instaUserRepository;
    private final ProfileRepository profileRepository;

    @Override
    @Transactional
    public OAuth2User loadUser(OAuth2UserRequest request) throws OAuth2AuthenticationException {
        var defService = new DefaultOAuth2UserService();
        var oauthUser = defService.loadUser(request);

        var registId = request.getClientRegistration().getRegistrationId();
        var userName = request.getClientRegistration()
                .getProviderDetails()
                .getUserInfoEndpoint()
                .getUserNameAttributeName();
        var oauthDto = OAuthAttr.from(registId, userName, oauthUser.getAttributes());
        if (oauthDto == null) {
            throw new OAuth2AuthenticationException(new OAuth2Error("not exist provider registration id"));
        }
        Profile curProfile = null;
        try {
            var user = instaUserRepository.findByEmail(oauthDto.getEmail()).orElse(null);
            if (user == null) {
                user = InstaUser.builder()
                        .email(oauthDto.getEmail())
                        .role(ERoles.USER)
                        .signProvider(registId)
                        .build();
                user = instaUserRepository.save(user);
                StringBuffer sb = new StringBuffer(user.getEmail());
                // 초기 nickname은 email, oauth provider의 조합으로 지정한다.
                int findPivot = sb.indexOf("@", 0);
                sb.delete(findPivot, sb.length());
                sb.append("_");
                sb.append(registId);
                curProfile = Profile.builder()
                        .accountId(user)
                        .nickname(sb.toString())
                        .build();
                curProfile = profileRepository.save(curProfile);
            } else {
                curProfile = profileRepository.findByAccountId(user).orElse(null);
                if (curProfile == null) {
                    throw new OAuth2AuthenticationException(new OAuth2Error("profile not exist.."));
                }
            }
        } catch (Exception e) {
            throw new OAuth2AuthenticationException(new OAuth2Error("unknown error"));
        }

        sessionDto.setEmail(oauthDto.getEmail());
        sessionDto.setNickname(oauthDto.getName());
        httpSession.setAttribute("sessionDto", sessionDto);

        // do something
        return oauthUser;
    }
}
