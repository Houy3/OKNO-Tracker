package ru.itis.okno.backend.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.itis.okno.backend.dto.base.Response;
import ru.itis.okno.backend.dto.user.UserDto;
import ru.itis.okno.backend.dto.user.UserLoginForm;

@Tags(value = {
        @Tag(name = "Authentication. Аутентификация.")
})
@RequestMapping("/auth")
public interface AuthApi {

    @Operation(summary = "Аутентифицироваться.")
    @PostMapping("/login")
    Response<UserDto> login(@RequestBody UserLoginForm dto);
}
