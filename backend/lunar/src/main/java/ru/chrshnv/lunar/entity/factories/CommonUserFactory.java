package ru.chrshnv.lunar.entity.factories;

import java.util.Set;

import org.springframework.stereotype.Service;

import ru.chrshnv.lunar.common.enums.UserGroup;
import ru.chrshnv.lunar.entity.interfaces.user.User;
import ru.chrshnv.lunar.entity.interfaces.user.UserFactory;
import ru.chrshnv.lunar.entity.models.CommonUser;

@Service
public class CommonUserFactory implements UserFactory {
    @Override
    public User create(String username, String password, String email) {
        return new CommonUser(username, password, email);
    }

    @Override
    public User create(Long id, String username, String password, String email) {
        return new CommonUser(id, username, password, email);
    }

    @Override
    public User create(Long id, String username, String password, String email, Set<UserGroup> userGroups) {
        return new CommonUser(id, username, password, email, userGroups);
    }
}
