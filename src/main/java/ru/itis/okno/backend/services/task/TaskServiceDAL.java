package ru.itis.okno.backend.services.task;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.okno.backend.dal.TaskRepository;
import ru.itis.okno.backend.dal.models.Task;
import ru.itis.okno.backend.dal.models.User;
import ru.itis.okno.backend.dto.task.TaskCreateDto;
import ru.itis.okno.backend.dto.task.TaskDto;
import ru.itis.okno.backend.dto.task.TaskPage;
import ru.itis.okno.backend.dto.task.TaskUpdateDto;
import ru.itis.okno.backend.exceptions.DataAccessException;
import ru.itis.okno.backend.exceptions.DataNotFoundException;
import ru.itis.okno.backend.services.utils.StackWalkerUtil;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class TaskServiceDAL implements TaskService {

    TaskRepository repository;
    TaskMapper mapper;

    public TaskDto create(TaskCreateDto dto, Long authId) {
        checkAccess(dto.userId, authId);
        return mapper.map(
                saveInternal(
                        mapper.map(dto)));
    }

    public TaskDto read(Long id, Long authId) {
        var dal = readInternal(id);
        checkAccess(dal.getUser().getId(), authId);
        return mapper.map(dal);
    }

    public TaskDto update(TaskUpdateDto dto, Long authId) {
        checkAccess(dto.userId, authId);

        var dal = readInternal(dto.id);
        checkAccess(dal.getUser().getId(), authId);

        return mapper.map(
                saveInternal(
                        mapper.map(dal, dto)));
    }

    public TaskDto delete(Long id, Long authId) {
        var dal = readInternal(id);
        checkAccess(dal.getUser().getId(), authId);
        repository.delete(dal);
        return mapper.map(dal);
    }

    public TaskDto markAsCompleted(Long id, Long authId) {
        var dal = readInternal(id);
        checkAccess(dal.getUser().getId(), authId);

        dal.setIsCompleted(true);
        dal.setCompletedTime(LocalDateTime.now());
        return mapper.map(
                saveInternal(dal));
    }

    public TaskDto markAsUncompleted(Long id, Long authId) {
        var dal = readInternal(id);
        checkAccess(dal.getUser().getId(), authId);

        dal.setIsCompleted(false);
        dal.setCompletedTime(null);
        return mapper.map(
                saveInternal(dal));
    }

    public TaskPage uncompletedListOrderByDeadline(Long userId, Integer page, Integer pageSize, Long authId) {
        checkAccess(userId, authId);

        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        Page<Task> contentPage = repository.findAllByUserAndIsCompletedOrderByDeadlineTime(pageRequest, new User(userId), false);

        return TaskPage.builder()
                .taskList(mapper.map(contentPage.getContent()))
                .totalPagesCount(contentPage.getTotalPages())
                .build();
    }

    public TaskPage completedListOrderByCompletedDesc(Long userId, Integer page, Integer pageSize, Long authId) {
        checkAccess(userId, authId);

        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        Page<Task> contentPage = repository.findAllByUserAndIsCompletedOrderByCompletedTimeDesc(pageRequest, new User(userId), true);

        return TaskPage.builder()
                .taskList(mapper.map(contentPage.getContent()))
                .totalPagesCount(contentPage.getTotalPages())
                .build();
    }


    protected Task readInternal(Long id) {
        var opt = repository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            throw new DataNotFoundException("Task", "id=" + id);
    }

    protected Task saveInternal(Task dal) {
        dal.setLastModifiedTime(LocalDateTime.now());
        return repository.save(dal);
    }

    protected void checkAccess(Long ownerId, Long authId) {
        if (!ownerId.equals(authId))
            throw new DataAccessException(StackWalkerUtil.getCaller(), ownerId, authId);
    }

}
