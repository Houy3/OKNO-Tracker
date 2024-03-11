package ru.itis.okno.backend.services.task;

import ru.itis.okno.backend.dto.task.TaskDto;

import java.util.List;

public interface TaskService {
    List<TaskDto> getTasks(Long id);
}
