package com.clone.insta.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ERoles {
    ADMIN("ROLE_ADMIN", "role for admin")
    , USER("ROLE_USER", "role for user");

    private final String name;
    private final String desc;

}
