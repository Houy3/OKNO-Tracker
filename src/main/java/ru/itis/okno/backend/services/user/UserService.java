package ru.itis.okno.backend.services.user;

import ru.itis.okno.backend.dto.user.*;

public interface UserService {

    UserDto create(UserCreateDto dto);

    UserDto read(Long id, Long authId);

    UserDto update(UserUpdateDto dto, Long authId);

    UserDto delete(Long id, Long authId);

    UserDto login(UserLoginForm loginForm);
}
