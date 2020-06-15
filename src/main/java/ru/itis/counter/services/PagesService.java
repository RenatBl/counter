package ru.itis.counter.services;

import ru.itis.counter.models.Page;
import ru.itis.counter.models.User;

import java.util.List;

public interface PagesService {
    List<Page> findAll(User user);
    Page getOne(Long id);
    void addNew(String url, User user);
}
