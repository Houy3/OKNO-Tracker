package ru.itis.okno.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import ru.itis.okno.backend.controllers.api.UserApi;
import ru.itis.okno.backend.dto.base.Response;
import ru.itis.okno.backend.dto.user.UserCreateDto;
import ru.itis.okno.backend.dto.user.UserDto;
import ru.itis.okno.backend.dto.user.UserUpdateDto;
import ru.itis.okno.backend.exceptions.ApplicationException;

import java.util.List;

@RestController
public class UserController implements UserApi {

    @Override
    public Response<UserDto> create(UserCreateDto dto) {
        throw new ApplicationException("not implemented","not implemented");
    }

    @Override
    public Response<UserDto> read(Long id, Long authId) {
        throw new ApplicationException("not implemented","not implemented");
    }

    @Override
    public Response<UserDto> update(UserUpdateDto dto, Long authId) {
        throw new ApplicationException("not implemented","not implemented");
    }

    @Override
    public Response<UserDto> delete(Long id, Long authId) {
        throw new ApplicationException("not implemented", "not implemented");
    }
}
