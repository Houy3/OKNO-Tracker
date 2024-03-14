package ru.itis.okno.backend.services.attachment;

import org.springframework.stereotype.Component;
import ru.itis.okno.backend.dal.models.Attachment;
import ru.itis.okno.backend.dal.models.Task;
import ru.itis.okno.backend.dto.attachment.AttachmentCreateDto;
import ru.itis.okno.backend.dto.attachment.AttachmentDto;
import ru.itis.okno.backend.dto.attachment.AttachmentNonContentDto;

@Component
public class AttachmentMapperImpl implements AttachmentMapper {

    public AttachmentDto map(Attachment dal) {
        return AttachmentDto.builder()
                .id(dal.getId())
                .name(dal.getName())
                .taskId(dal.getTask().getId())
                .contentType(dal.getContentType())
                .content(dal.getContent())
                .build();
    }

    public AttachmentNonContentDto mapNonContent(Attachment dal) {
        return AttachmentNonContentDto.builder()
                .id(dal.getId())
                .name(dal.getName())
                .taskId(dal.getTask().getId())
                .contentType(dal.getContentType())
                .build();
    }

    public Attachment map(AttachmentCreateDto dto) {
        return Attachment.builder()
                .name(dto.name)
                .contentType(dto.contentType)
                .task(new Task(dto.taskId))
                .content(dto.content)
                .build();
    }
}
