package ru.itis.okno.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import ru.itis.okno.backend.controllers.api.AuthApi;
import ru.itis.okno.backend.dto.base.Response;
import ru.itis.okno.backend.dto.user.UserDto;
import ru.itis.okno.backend.exceptions.ApplicationException;

@RestController
public class AuthController implements AuthApi {

    @Override
    public Response<UserDto> login(String login, String password) {
        throw new ApplicationException("not implemented","not implemented");
    }
}
