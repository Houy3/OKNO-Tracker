package ru.itis.okno.backend.dto.user;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Пользователь.")
public class UserDto {

    @Schema(description = "Идентификатор.")
    public Long id;

    @Schema(description = "Логин.")
    public String login;

}
