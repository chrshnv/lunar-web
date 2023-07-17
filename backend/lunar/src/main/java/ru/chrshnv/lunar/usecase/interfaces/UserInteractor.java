package ru.chrshnv.lunar.usecase.interfaces;

import ru.chrshnv.lunar.usecase.models.UserRequestModel;
import ru.chrshnv.lunar.usecase.models.UserResponseModel;

public interface UserInteractor {
    UserResponseModel create(UserRequestModel requestModel);
}
