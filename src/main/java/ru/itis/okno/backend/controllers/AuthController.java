package ru.itis.okno.backend.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.okno.backend.controllers.api.AuthApi;
import ru.itis.okno.backend.dto.base.Response;
import ru.itis.okno.backend.dto.user.UserDto;
import ru.itis.okno.backend.dto.user.UserLoginForm;
import ru.itis.okno.backend.services.user.UserService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController implements AuthApi {

    UserService service;

    @Override
    public Response<UserDto> login(UserLoginForm dto) {
        return Response.of(
                service.login(dto));
    }
}
