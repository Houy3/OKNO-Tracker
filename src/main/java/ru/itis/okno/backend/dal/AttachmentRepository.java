package ru.itis.okno.backend.dal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.okno.backend.dal.models.Attachment;

public interface AttachmentRepository extends JpaRepository<Attachment, Long> {

    Page<Attachment> findAllByTaskId(Pageable pageable, Long taskId);

}
