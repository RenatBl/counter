package ru.itis.counter.dto;

import javafx.util.Pair;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.counter.models.Page;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDto {

    private Long id;
    private String url;
    private Integer quantityOfWords;
    private Map<String, Integer> words;
    private String mostFrequentWord;

    public static PageDto get(Page page) {
        return PageDto.builder()
                .id(page.getId())
                .url(page.getUrl())
                .quantityOfWords(page.getWordsQuantity())
                .words(page.getWords())
                .mostFrequentWord(getMostFrequentWord(page.getWords()))
                .build();
    }

    public static List<PageDto> get(List<Page> pages) {
        return pages.stream()
                .map(PageDto::get)
                .collect(Collectors.toList());
    }

    private static String getMostFrequentWord(Map<String, Integer> words) {
        return Collections.max(words.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
    }
}
