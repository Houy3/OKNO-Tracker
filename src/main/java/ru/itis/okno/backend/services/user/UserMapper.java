package ru.itis.okno.backend.services.user;

import ru.itis.okno.backend.dal.models.User;
import ru.itis.okno.backend.dto.user.UserCreateDto;
import ru.itis.okno.backend.dto.user.UserDto;
import ru.itis.okno.backend.dto.user.UserUpdateDto;

public interface UserMapper {

    UserDto map(User dal);

    User map(UserCreateDto dto);

    User map(User dal, UserUpdateDto dto);
}
