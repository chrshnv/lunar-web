package ru.chrshnv.lunar.usecase.interfaces;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;

public interface UserJwtEncoder {
    String encode(JwtClaimsSet claimsSet);
}
