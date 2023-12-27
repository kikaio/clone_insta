package com.clone.insta.dto;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import java.util.Map;

import com.clone.insta.enums.EAuthProvider;

@Getter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class OAuthAttr {
    private Map<String, Object> attr;
    private String nameAttrKey;
    private String name;
    private String email;

    public static OAuthAttr from(String registrationId, String userNameAttr, Map<String, Object> attr)
    {
        for(EAuthProvider eval : EAuthProvider.values())
        {
            if(eval.useable == false)
                continue;
            if(eval.provider.equals(registrationId) == false)
                continue;
            switch (eval) {
                case GOOGLE:
                {
                    return fromGoogle(userNameAttr, attr);
                }
                default:
                    return null;
            }
        }
        return null;
    }

    private static OAuthAttr fromGoogle(String userNameAttr, Map<String, Object> attr)
    {
        return OAuthAttr.builder()
            .name((String)attr.get("name"))
            .email((String)attr.get("email"))
            .attr(attr)
            .nameAttrKey(userNameAttr)
            .build()
        ;
    }
}
