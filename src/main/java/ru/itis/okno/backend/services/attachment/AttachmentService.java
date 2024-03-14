package ru.itis.okno.backend.services.attachment;

import ru.itis.okno.backend.dto.attachment.AttachmentCreateDto;
import ru.itis.okno.backend.dto.attachment.AttachmentDto;
import ru.itis.okno.backend.dto.attachment.AttachmentNonContentDto;
import ru.itis.okno.backend.dto.attachment.AttachmentPage;

public interface AttachmentService {
    AttachmentNonContentDto create(AttachmentCreateDto dto, Long authId);

    AttachmentDto read(Long id, Long authId);

    AttachmentPage listByTask(Long taskId, Integer page, Integer pageSize,  Long authId);

    AttachmentNonContentDto delete(Long id, Long authId);
}
