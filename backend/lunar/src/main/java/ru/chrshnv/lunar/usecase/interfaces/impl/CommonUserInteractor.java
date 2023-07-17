package ru.chrshnv.lunar.usecase.interfaces.impl;

import org.springframework.stereotype.Component;

import ru.chrshnv.lunar.entity.interfaces.user.User;
import ru.chrshnv.lunar.entity.interfaces.user.UserFactory;
import ru.chrshnv.lunar.usecase.interfaces.UserInteractor;
import ru.chrshnv.lunar.usecase.interfaces.UserPresenter;
import ru.chrshnv.lunar.usecase.interfaces.UserSaveGateway;
import ru.chrshnv.lunar.usecase.models.UserRequestModel;
import ru.chrshnv.lunar.usecase.models.UserResponseModel;
import ru.chrshnv.lunar.usecase.models.db.UserDsModel;

@Component
public class CommonUserInteractor implements UserInteractor {
    private final UserFactory userFactory;
    private final UserSaveGateway userRepository;
    private final UserPresenter userPresenter;

    public CommonUserInteractor(UserFactory userFactory, UserSaveGateway userRepository, UserPresenter userPresenter) {
        this.userFactory = userFactory;
        this.userRepository = userRepository;
        this.userPresenter = userPresenter;
    }

    @Override
    public UserResponseModel create(UserRequestModel requestModel) {
        if (userRepository.existsByUsername(requestModel.getUsername()))
            return userPresenter.prepareFailView("Username already exists");

        User user = userFactory.create(requestModel.getUsername(), requestModel.getPassword(), requestModel.getEmail());
        if (!user.emailIsValid() || !user.passwordIsValid())
            return userPresenter.prepareFailView("Invalid email or password");

        UserDsModel requestBody = new UserDsModel(user.getId(), user.getUsername(), user.getPassword(), user.getEmail(), user.getUserGroups());
        UserDsModel responseBody = userRepository.save(requestBody);
        
        UserResponseModel responseModel = new UserResponseModel(responseBody.getId(), responseBody.getUsername(), responseBody.getEmail(), responseBody.getUserGroups());
        return userPresenter.prepareSuccessView(responseModel);
    }
}
