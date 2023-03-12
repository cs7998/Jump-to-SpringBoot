package com.uhshin.sbb.user;

import lombok.Getter;

//@Setter 없는 이유는 상수형이므로 set 할 필요가 없다.
@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    UserRole(String value) {
        this.value = value;
    }

    private String value;
}