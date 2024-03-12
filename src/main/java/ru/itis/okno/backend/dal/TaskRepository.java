package ru.itis.okno.backend.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.okno.backend.dal.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
