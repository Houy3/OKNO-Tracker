package ru.itis.okno.backend.services.attachment;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ru.itis.okno.backend.dal.AttachmentRepository;
import ru.itis.okno.backend.dal.models.Attachment;
import ru.itis.okno.backend.dto.attachment.AttachmentCreateDto;
import ru.itis.okno.backend.dto.attachment.AttachmentDto;
import ru.itis.okno.backend.dto.attachment.AttachmentNonContentDto;
import ru.itis.okno.backend.dto.attachment.AttachmentPage;
import ru.itis.okno.backend.exceptions.DataAccessException;
import ru.itis.okno.backend.exceptions.DataNotFoundException;
import ru.itis.okno.backend.services.task.TaskService;
import ru.itis.okno.backend.services.utils.StackWalkerUtil;


@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AttachmentServiceDAL implements AttachmentService {

    AttachmentRepository repository;
    AttachmentMapper mapper;

    TaskService taskService;

    public AttachmentNonContentDto create(AttachmentCreateDto dto, Long authId) {
        checkAccess(taskService.read(dto.taskId, authId).userId, authId);
        return mapper.mapNonContent(
                repository.save(
                        mapper.map(dto)));
    }

    public AttachmentDto read(Long id, Long authId) {
        var dal = readInternal(id);
        checkAccess(dal.getTask().getUser().getId(), authId);
        return mapper.map(dal);
    }

    public AttachmentPage listByTask(Long taskId, Integer page, Integer pageSize, Long authId) {
        checkAccess(taskService.read(taskId, authId).userId, authId);

        PageRequest pageRequest = PageRequest.of(page - 1, pageSize);
        Page<Attachment> contentPage = repository.findAllByTaskId(pageRequest, taskId);

        return AttachmentPage.builder()
                .attachmentList(mapper.mapNonContent(contentPage.getContent()))
                .totalPagesCount(contentPage.getTotalPages())
                .build();
    }

    public AttachmentNonContentDto delete(Long id, Long authId) {
        var dalNonContent = readInternal(id);
        checkAccess(dalNonContent.getTask().getUser().getId(), authId);
        repository.deleteById(dalNonContent.getId());
        return mapper.mapNonContent(dalNonContent);
    }

    protected Attachment readInternal(Long id) {
        var opt = repository.findById(id);
        if (opt.isPresent())
            return opt.get();
        else
            throw new DataNotFoundException("Task", "id=" + id);
    }

    protected void checkAccess(Long userId, Long authId) {
        if (!userId.equals(authId))
            throw new DataAccessException(StackWalkerUtil.getCaller(), userId, authId);
    }

}
