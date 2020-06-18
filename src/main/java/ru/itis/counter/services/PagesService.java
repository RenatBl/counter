package ru.itis.counter.services;

import ru.itis.counter.dto.PageInfoDto;
import ru.itis.counter.models.Page;
import ru.itis.counter.models.User;

import java.util.List;

public interface PagesService {
    List<PageInfoDto> findAll(User user);
    Page getOne(Long id);
    void addNew(String url, User user);
}
