package ru.chrshnv.lunar.usecase.interfaces.impl;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import ru.chrshnv.lunar.usecase.interfaces.UserPresenter;
import ru.chrshnv.lunar.usecase.models.UserResponseModel;

@Component
public class CommonUserPresenter implements UserPresenter {
    @Override
    public UserResponseModel prepareFailView(String message) {
        throw new ResponseStatusException(HttpStatus.CONFLICT, message);
    }

    @Override
    public UserResponseModel prepareSuccessView(UserResponseModel responseModel) {
        // TODO Auto-generated method stub
        return responseModel;
    }
}
