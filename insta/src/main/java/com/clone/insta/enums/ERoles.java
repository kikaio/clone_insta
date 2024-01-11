package com.clone.insta.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ERoles {
    ADMIN("ADMIN")
    , USER("USER");

    private final String name;
}
