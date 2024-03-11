package ru.itis.okno.backend.dto.task;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "DTO для создания задачи.")
public class TaskCreateDto {

    @Schema(description = "Название.")
    public String name;

    @Schema(description = "Описание.")
    public String description;

    @Schema(description = "Автор.")
    public long userId;

    @Schema(description = "Дата начала работы над задачей.")
    public LocalDateTime creationTime;

    @Schema(description = "Дата дедлайна.")
    public LocalDateTime deadlineTime;

}
