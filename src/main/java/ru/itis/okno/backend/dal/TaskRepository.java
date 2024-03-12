package ru.itis.okno.backend.dal;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.okno.backend.dal.models.Task;
import ru.itis.okno.backend.dal.models.User;

public interface TaskRepository extends JpaRepository<Task, Long> {

    Page<Task> findAllByUserAndIsCompletedOrderByDeadlineTime(Pageable pageable, User user, Boolean isCompleted);


    Page<Task> findAllByUserAndIsCompletedOrderByCompletedTimeDesc(Pageable pageable, User user, Boolean isCompleted);
}
