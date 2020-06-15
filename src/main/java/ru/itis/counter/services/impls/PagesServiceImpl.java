package ru.itis.counter.services.impls;

import org.springframework.stereotype.Service;
import ru.itis.counter.models.Page;
import ru.itis.counter.models.User;
import ru.itis.counter.repositories.PagesRepository;
import ru.itis.counter.services.PagesService;
import ru.itis.counter.utils.PageSavingUtil;

import java.util.List;

@Service
public class PagesServiceImpl implements PagesService {

    private final PagesRepository pagesRepository;

    public PagesServiceImpl(PagesRepository pagesRepository) {
        this.pagesRepository = pagesRepository;
    }

    @Override
    public List<Page> findAll(User user) {
        return pagesRepository.findAllByOwner(user);
    }

    @Override
    public Page getOne(Long id) {
        return pagesRepository.getOne(id);
    }

    @Override
    public void addNew(String url) {
        PageSavingUtil.savePage(url);
        pagesRepository.save(Page.builder()
                .url(url)
                .build());
    }
}
