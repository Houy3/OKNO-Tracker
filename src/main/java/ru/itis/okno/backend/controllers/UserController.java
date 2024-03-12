package ru.itis.okno.backend.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.okno.backend.controllers.api.UserApi;
import ru.itis.okno.backend.dto.base.Response;
import ru.itis.okno.backend.dto.user.UserCreateDto;
import ru.itis.okno.backend.dto.user.UserDto;
import ru.itis.okno.backend.dto.user.UserUpdateDto;
import ru.itis.okno.backend.services.user.UserService;

@RestController
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController implements UserApi {

    UserService service;

    @Override
    public Response<UserDto> create(UserCreateDto dto) {
        return Response.of(
                service.create(dto));
    }

    @Override
    public Response<UserDto> read(Long id, Long authId) {
        return Response.of(
                service.read(id, authId));
    }

    @Override
    public Response<UserDto> update(UserUpdateDto dto, Long authId) {
        return Response.of(
                service.update(dto, authId));
    }

    @Override
    public Response<UserDto> delete(Long id, Long authId) {
        return Response.of(
                service.delete(id, authId));
    }
}
