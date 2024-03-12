package ru.itis.okno.backend.services.task;

import ru.itis.okno.backend.dal.models.Task;
import ru.itis.okno.backend.dto.task.TaskCreateDto;
import ru.itis.okno.backend.dto.task.TaskDto;
import ru.itis.okno.backend.dto.task.TaskUpdateDto;

public interface TaskMapper {
    TaskDto map(Task dal);

    Task map(TaskCreateDto dto);

    Task map(Task dal, TaskUpdateDto dto);
}
