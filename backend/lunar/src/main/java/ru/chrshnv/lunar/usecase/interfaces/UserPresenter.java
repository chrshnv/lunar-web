package ru.chrshnv.lunar.usecase.interfaces;

import ru.chrshnv.lunar.usecase.models.UserResponseModel;

public interface UserPresenter {
    UserResponseModel prepareFailView(String message);
    
    UserResponseModel prepareSuccessView(UserResponseModel responseModel);
}
