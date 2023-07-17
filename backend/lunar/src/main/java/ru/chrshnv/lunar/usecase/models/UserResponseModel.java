package ru.chrshnv.lunar.usecase.models;

import java.util.Set;

import ru.chrshnv.lunar.common.enums.UserGroup;

public class UserResponseModel {
    private Long id;
    private String username;
    private String email;
    private Set<UserGroup> userGroups;

    public UserResponseModel() {
    }
    
    public UserResponseModel(Long id, String username, String email, Set<UserGroup> userGroups) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.userGroups = userGroups;
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
}
