package ru.itis.counter.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ru.itis.counter.utils.WordsFindingUtil;

import javax.persistence.*;
import java.util.Map;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Slf4j
public class Page {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String url;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "ownerId")
    private User owner;

    @Transient
    private Integer wordsQuantity;

    @Transient
    private Map<String, Integer> words;

    @PostLoad
    public void loadPageInfo() {
        words = WordsFindingUtil.getWordsOnPage(url);
        wordsQuantity = words.size();
        log.info("Page " + url + " loaded");
    }
}
