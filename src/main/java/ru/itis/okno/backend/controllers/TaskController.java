package ru.itis.okno.backend.controllers;

import org.springframework.web.bind.annotation.RestController;
import ru.itis.okno.backend.controllers.api.TaskApi;
import ru.itis.okno.backend.dto.base.Response;
import ru.itis.okno.backend.dto.task.TaskCreateDto;
import ru.itis.okno.backend.dto.task.TaskDto;
import ru.itis.okno.backend.dto.task.TaskUpdateDto;
import ru.itis.okno.backend.exceptions.ApplicationException;

@RestController
public class TaskController implements TaskApi {
    @Override
    public Response<TaskDto> create(TaskCreateDto dto, Long authId) {
        throw new ApplicationException("not implemented","not implemented");
    }

    @Override
    public Response<TaskDto> read(Long id, Long authId) {
        throw new ApplicationException("not implemented","not implemented");
    }

    @Override
    public Response<TaskDto> update(TaskUpdateDto dto, Long authId) {
        throw new ApplicationException("not implemented","not implemented");
    }

    @Override
    public Response<TaskDto> delete(Long id, Long authId) {
        throw new ApplicationException("not implemented","not implemented");
    }

    @Override
    public Response<TaskDto> makeCompleted(Long id, Long authId) {
        throw new ApplicationException("not implemented","not implemented");
    }
}
