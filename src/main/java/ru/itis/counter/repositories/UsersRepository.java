package ru.itis.counter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.counter.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
