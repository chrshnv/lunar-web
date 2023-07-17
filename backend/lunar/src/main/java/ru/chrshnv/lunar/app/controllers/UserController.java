package ru.chrshnv.lunar.app.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.chrshnv.lunar.usecase.interfaces.UserInteractor;
import ru.chrshnv.lunar.usecase.models.UserRequestModel;
import ru.chrshnv.lunar.usecase.models.UserResponseModel;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserInteractor userInteractor;

    public UserController(UserInteractor userInteractor) {
        this.userInteractor = userInteractor;
    }

    @PutMapping
    public ResponseEntity<UserResponseModel> create(@RequestBody UserRequestModel requestModel) {
        return ResponseEntity.ok(userInteractor.create(requestModel));
    }
}
