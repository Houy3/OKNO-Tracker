package ru.itis.okno.backend.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.okno.backend.dto.base.Response;
import ru.itis.okno.backend.dto.user.UserDto;

@Tags(value = {
        @Tag(name = "Authentication. Аутентификация.")
})
@RequestMapping("/auth")
public interface AuthApi {

    @Operation(summary = "Аутентифицироваться.")
    @GetMapping("/login")
    Response<UserDto> login(@Parameter(description = "Логин.")
                           @RequestParam String login,
                           @Parameter(description = "Пароль.")
                           @RequestParam String password);

}
