package ru.itis.okno.backend.dto.task;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;

@Schema(description = "DTO для изменения задачи.")
public class TaskUpdateDto {

    @Schema(description = "Идентификатор.")
    public Long id;

    @Schema(description = "Название.")
    public String name;

    @Schema(description = "Описание.")
    public String description;

    @Schema(description = "Дата начала работы над задачей.")
    public LocalDateTime startTime;

    @Schema(description = "Дата дедлайна.")
    public LocalDateTime deadlineTime;
}