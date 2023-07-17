package ru.chrshnv.lunar.entity.models;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import ru.chrshnv.lunar.common.enums.UserGroup;
import ru.chrshnv.lunar.entity.interfaces.user.User;

public class CommonUser implements User {
    private Long id = null;
    private String username;
    private String password;
    private String email;
    private Set<UserGroup> userGroups = new HashSet<>(Arrays.asList(UserGroup.User));

    public CommonUser(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public CommonUser(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public CommonUser(Long id, String username, String password, String email, Set<UserGroup> userGroups) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.userGroups = userGroups;
    }

    @Override
    public boolean passwordIsValid() {
        // check password min length 8
        return password != null && password.length() >= 8;
    }

    @Override
    public boolean emailIsValid() {
        String pattern = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?";
        return email != null && Pattern.compile(pattern).matcher(email).matches();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public Set<UserGroup> getUserGroups() {
        return Collections.unmodifiableSet(userGroups);
    }
}
