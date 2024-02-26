package ru.itis.okno.backend.dto.task;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "Задача.")
public class TaskDto {

    @Schema(description = "Идентификатор.")
    public long id;

    @Schema(description = "Название.")
    public String name;

    @Schema(description = "Описание.")
    public String description;

    @Schema(description = "Автор.")
    public long userId;

    @Schema(description = "Сделана ли задача.")
    public Boolean isCompleted;


    @Schema(description = "Дата последнего изменения.")
    public LocalDateTime lastChangeTime;

    @Schema(description = "Дата начала работы над задачей.")
    public LocalDateTime startTime;

    @Schema(description = "Дата дедлайна.")
    public LocalDateTime deadlineTime;

    @Schema(description = "Дата выполнения.")
    public LocalDateTime completedTime;

}
