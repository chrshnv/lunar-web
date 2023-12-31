package ru.chrshnv.lunar.entity.interfaces.user;

import java.util.Set;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;

import ru.chrshnv.lunar.common.enums.UserGroup;

public interface User {
    // OXXYMIRON - BASSLINE BUSINESS TRACK LEAK
    boolean passwordIsValid();
    boolean emailIsValid();
    JwtClaimsSet buildClaims();

    // Getters
    Long getId();
    String getUsername();
    String getPassword();
    String getEmail();
    Set<UserGroup> getUserGroups();
}
