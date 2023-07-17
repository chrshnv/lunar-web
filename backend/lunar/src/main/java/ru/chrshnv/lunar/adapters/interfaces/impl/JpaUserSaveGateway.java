package ru.chrshnv.lunar.adapters.interfaces.impl;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import ru.chrshnv.lunar.adapters.interfaces.JpaUserRepository;
import ru.chrshnv.lunar.adapters.models.UserDataMapper;
import ru.chrshnv.lunar.usecase.interfaces.UserSaveGateway;
import ru.chrshnv.lunar.usecase.models.db.UserDsModel;

@Repository
public class JpaUserSaveGateway implements UserSaveGateway {
    private final JpaUserRepository userRepository;

    public JpaUserSaveGateway(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDsModel save(UserDsModel requestModel) {
        UserDataMapper requestBody = new UserDataMapper(requestModel.getId(), requestModel.getUsername(), requestModel.getPassword(), requestModel.getEmail(), requestModel.getUserGroups());
        UserDataMapper responseBody = userRepository.save(requestBody);
        
        UserDsModel responseModel = new UserDsModel(responseBody.getId(), responseBody.getUsername(), requestBody.getPassword(), responseBody.getEmail(), responseBody.getUserGroups());
        return responseModel;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsById(Long id) {
        return existsById(id);
    }

    @Override
    public Optional<UserDsModel> findByUsername(String username) {
        return userRepository
            .findByUsername(username)
            .map(i -> new UserDsModel(i.getId(), i.getUsername(), i.getPassword(), i.getEmail(), i.getUserGroups()));
    }

    @Override
    public Optional<UserDsModel> findById(Long id) {
        return userRepository
            .findById(id)
            .map(i -> new UserDsModel(i.getId(), i.getUsername(), i.getPassword(), i.getEmail(), i.getUserGroups()));
    }
    
}
