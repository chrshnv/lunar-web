package ru.chrshnv.lunar.adapters.interfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import ru.chrshnv.lunar.adapters.models.UserDataMapper;

public interface JpaUserRepository extends CrudRepository<UserDataMapper, Long> {
    boolean existsByUsername(String username);

    Optional<UserDataMapper> findByUsername(String username);
}
