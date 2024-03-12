package ru.itis.okno.backend.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO для создания пользователя.")
public class UserCreateDto {

    @Schema(description = "Электронная почта.")
    public String email;

    @Schema(description = "Пароль.")
    public String password;
}
