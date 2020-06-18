package ru.itis.counter.services.impls;

import org.springframework.stereotype.Service;
import ru.itis.counter.dto.PageInfoDto;
import ru.itis.counter.models.Page;
import ru.itis.counter.models.User;
import ru.itis.counter.models.WordsReport;
import ru.itis.counter.repositories.PagesRepository;
import ru.itis.counter.repositories.WordsReportRepository;
import ru.itis.counter.services.PagesService;
import ru.itis.counter.utils.PageSavingUtil;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PagesServiceImpl implements PagesService {

    private final PagesRepository pagesRepository;
    private final WordsReportRepository wordsReportRepository;

    public PagesServiceImpl(PagesRepository pagesRepository, WordsReportRepository wordsReportRepository) {
        this.pagesRepository = pagesRepository;
        this.wordsReportRepository = wordsReportRepository;
    }

    @Override
    public List<PageInfoDto> findAll(User user) {
        return new ArrayList<>(pagesRepository.getAllPages(user));
    }

    @Override
    public Page getOne(Long id) {
        Page page = pagesRepository.getOne(id);

        wordsReportRepository.save(WordsReport.builder()
                .page(page)
                .wordsQuantity(page.getWordsQuantity())
                .dateOfSearch(LocalDateTime.now())
                .build());

        return page;
    }

    @Override
    public void addNew(String url, User user) {
        PageSavingUtil.savePage(url);
        pagesRepository.save(Page.builder()
                .url(url)
                .owner(user)
                .build());
    }
}
