package ru.itis.okno.backend.services.task;

import ru.itis.okno.backend.dto.task.TaskCreateDto;
import ru.itis.okno.backend.dto.task.TaskDto;
import ru.itis.okno.backend.dto.task.TaskUpdateDto;

public interface TaskService {

    TaskDto create(TaskCreateDto dto, Long authId);

    TaskDto read(Long id, Long authId);

    TaskDto update(TaskUpdateDto dto, Long authId);

    TaskDto delete(Long id, Long authId);

    TaskDto markAsCompleted(Long id, Long authId);

    TaskDto markAsUncompleted(Long id, Long authId);

}
