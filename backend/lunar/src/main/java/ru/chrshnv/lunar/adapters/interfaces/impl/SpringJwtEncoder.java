package ru.chrshnv.lunar.adapters.interfaces.impl;

import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import ru.chrshnv.lunar.usecase.interfaces.UserJwtEncoder;

@Component
public class SpringJwtEncoder implements UserJwtEncoder {
    private final JwtEncoder jwtEncoder;
    public SpringJwtEncoder(JwtEncoder jwtEncoder) {
        this.jwtEncoder = jwtEncoder;
    }

    @Override
    public String encode(JwtClaimsSet claimsSet) {
        return jwtEncoder.encode(JwtEncoderParameters.from(claimsSet)).getTokenValue();
    }
}
