package ru.chrshnv.lunar.usecase.models;

import java.util.Set;
import java.util.UUID;

import ru.chrshnv.lunar.common.enums.UserGroup;

public class UserResponseModel {
    private Long id;
    private String username;
    private String email;
    private Set<UserGroup> userGroups;
    private String accessToken = null;
    private UUID refreshToken = null;

    public UserResponseModel() {
    }
    
    public UserResponseModel(Long id, String username, String email, Set<UserGroup> userGroups) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userGroups = userGroups;
    }

    public UserResponseModel(Long id, String username, String email, Set<UserGroup> userGroups, String accessToken,
            UUID refreshToken) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userGroups = userGroups;
        this.accessToken = accessToken;
        this.refreshToken = refreshToken;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Set<UserGroup> getUserGroups() {
        return userGroups;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public UUID getRefreshToken() {
        return refreshToken;
    }
}
