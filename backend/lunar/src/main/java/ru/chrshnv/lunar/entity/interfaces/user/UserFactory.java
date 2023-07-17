package ru.chrshnv.lunar.entity.interfaces.user;

import java.util.Set;

import ru.chrshnv.lunar.common.enums.UserGroup;

public interface UserFactory {
    User create(String username, String password, String email);

    User create(Long id, String username, String password, String email);
    
    User create(Long id, String username, String password, String email, Set<UserGroup> userGroups);
}
