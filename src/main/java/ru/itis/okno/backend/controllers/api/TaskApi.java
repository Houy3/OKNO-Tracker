package ru.itis.okno.backend.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.web.bind.annotation.*;
import ru.itis.okno.backend.dto.base.Response;
import ru.itis.okno.backend.dto.task.*;

@Tags(value = {
        @Tag(name = "Task. Задача.")
})
@RequestMapping("/task")
public interface TaskApi {

    @Operation(summary = "Добавить.")
    @PostMapping
    Response<TaskDto> create(@RequestBody TaskCreateDto dto,
                             @Parameter(description = "Идентификатор для авторизации.")
                             @RequestParam Long authId);

    @Operation(summary = "Получить.")
    @GetMapping("/{task-id}")
    Response<TaskDto> read(@Parameter(description = "Идентификатор.")
                           @PathVariable("task-id") Long id,
                           @Parameter(description = "Идентификатор для авторизации.")
                           @RequestParam Long authId);

    @Operation(summary = "Изменить.")
    @PutMapping
    Response<TaskDto> update(@RequestBody TaskUpdateDto dto,
                             @Parameter(description = "Идентификатор для авторизации.")
                             @RequestParam Long authId);

    @Operation(summary = "Удалить.")
    @DeleteMapping("/{Task-id}")
    Response<TaskDto> delete(@Parameter(description = "Идентификатор.")
                             @PathVariable("Task-id") Long id,
                             @Parameter(description = "Идентификатор для авторизации.")
                             @RequestParam Long authId);


    @Operation(summary = "Пометить выполненным.")
    @PutMapping("/{task-id}")
    Response<TaskDto> makeCompleted(@Parameter(description = "Идентификатор.")
                                    @PathVariable("task-id") Long id,
                                    @Parameter(description = "Идентификатор для авторизации.")
                                    @RequestParam Long authId);

}
