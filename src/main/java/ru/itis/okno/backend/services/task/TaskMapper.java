package ru.itis.okno.backend.services.task;

import ru.itis.okno.backend.dal.models.Task;
import ru.itis.okno.backend.dto.task.TaskCreateDto;
import ru.itis.okno.backend.dto.task.TaskDto;
import ru.itis.okno.backend.dto.task.TaskUpdateDto;

import java.util.List;

public interface TaskMapper {
    TaskDto map(Task dal);

    default List<TaskDto> map(List<Task> dalList) {
        return dalList.stream().map(this::map).toList();
    }

    Task map(TaskCreateDto dto);

    Task map(Task dal, TaskUpdateDto dto);
}
