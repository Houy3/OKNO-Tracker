package ru.itis.okno.backend.dal;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.okno.backend.dal.models.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {


    Optional<User> getByEmailAndPasswordHash(String email, String passwordHash);

    Boolean existsByEmail(String email);
}
