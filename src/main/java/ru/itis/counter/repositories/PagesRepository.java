package ru.itis.counter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.counter.models.Page;
import ru.itis.counter.models.User;

import java.util.List;

public interface PagesRepository extends JpaRepository<Page, Long> {
    List<Page> findAllByOwner(User user);
}
