package ru.chrshnv.lunar.usecase.interfaces;

import java.util.Optional;

import ru.chrshnv.lunar.usecase.models.db.UserDsModel;

public interface UserSaveGateway {
    UserDsModel save(UserDsModel requestModel);

    boolean existsByUsername(String username);
    boolean existsById(Long id);

    Optional<UserDsModel> findByUsername(String username);
    Optional<UserDsModel> findById(Long id);
}
