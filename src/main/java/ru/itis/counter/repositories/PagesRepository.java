package ru.itis.counter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.itis.counter.dto.PageInfoDto;
import ru.itis.counter.models.Page;
import ru.itis.counter.models.User;

import java.util.Collection;

public interface PagesRepository extends JpaRepository<Page, Long> {

    @Query("select new ru.itis.counter.dto.PageInfoDto(page.id, page.url) from Page page where page.owner = :user")
    Collection<PageInfoDto> getAllPages(@Param("user") User user);
}
