package ru.itis.okno.backend.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO для изменения пользователя.")
public class UserUpdateDto {

    @Schema(description = "Идентификатор.")
    public Long id;

    @Schema(description = "Логин.")
    public String login;

    @Schema(description = "Пароль.")
    public String password;
}
