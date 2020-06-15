package ru.itis.counter.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.counter.models.Page;

import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PageDto {

    private Long id;
    private String url;
    private Integer quantityOfWords;

    public static PageDto get(Page page) {
        return PageDto.builder()
                .id(page.getId())
                .url(page.getUrl())
                .quantityOfWords(page.getWordsQuantity())
                .build();
    }

    public static List<PageDto> get(List<Page> pages) {
        return pages.stream()
                .map(PageDto::get)
                .collect(Collectors.toList());
    }
}
