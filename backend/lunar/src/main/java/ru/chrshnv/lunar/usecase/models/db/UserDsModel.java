package ru.chrshnv.lunar.usecase.models.db;

import java.util.Collections;
import java.util.Set;

import ru.chrshnv.lunar.common.enums.UserGroup;

public class UserDsModel {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Set<UserGroup> userGroups;
    
    public UserDsModel(Long id, String username, String password, String email, Set<UserGroup> userGroups) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userGroups = userGroups;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Set<UserGroup> getUserGroups() {
        return Collections.unmodifiableSet(userGroups);
    }
}
