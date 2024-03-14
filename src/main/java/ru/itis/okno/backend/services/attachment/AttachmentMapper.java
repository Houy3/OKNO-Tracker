package ru.itis.okno.backend.services.attachment;

import ru.itis.okno.backend.dal.models.Attachment;
import ru.itis.okno.backend.dto.attachment.AttachmentCreateDto;
import ru.itis.okno.backend.dto.attachment.AttachmentDto;
import ru.itis.okno.backend.dto.attachment.AttachmentNonContentDto;

import java.util.List;

public interface AttachmentMapper {

    AttachmentDto map(Attachment dal);

    AttachmentNonContentDto mapNonContent(Attachment dal);
    default List<AttachmentNonContentDto> mapNonContent(List<Attachment> dalList) {
        return dalList.stream().map(this::mapNonContent).toList();
    }

    Attachment map(AttachmentCreateDto dto);

}
