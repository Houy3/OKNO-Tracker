package ru.itis.okno.backend.services.user;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;
import ru.itis.okno.backend.dal.models.User;
import ru.itis.okno.backend.dto.user.UserCreateDto;
import ru.itis.okno.backend.dto.user.UserDto;
import ru.itis.okno.backend.dto.user.UserUpdateDto;
import ru.itis.okno.backend.services.utils.HashGenerator;

@Component
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserMapperImpl implements UserMapper {

    HashGenerator hashGenerator;

    public UserDto map(User dal) {
        return UserDto.builder()
                .id(dal.getId())
                .email(dal.getEmail())
                .build();
    }

    public User map(UserCreateDto dto) {
        return User.builder()
                .email(dto.email)
                .passwordHash(hashGenerator.hash(dto.password))
                .build();
    }

    public User map(User dal, UserUpdateDto dto) {
        dal.setEmail(dto.email);
        dal.setPasswordHash(hashGenerator.hash(dto.password));
        return dal;
    }
}
