package ru.itis.counter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.counter.models.WordsReport;

public interface WordsReportRepository extends JpaRepository<WordsReport, Long> {
}
