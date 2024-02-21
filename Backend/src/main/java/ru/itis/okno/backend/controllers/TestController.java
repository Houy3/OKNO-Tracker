package ru.itis.okno.backend.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/test")
public class TestController {

    @Operation(summary = "Получение списка задач", description = "Доступно всем пользователям")
    @GetMapping
    public String Test() {
        return "wow";
    }
}
