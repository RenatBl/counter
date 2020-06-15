package ru.itis.counter.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordsFindingService {

    private static final Map<String, Integer> words = new HashMap<>();
    private static final String delimiters = " |\\n|\\r|\\t|,|;|\\.|\\?|!|-|:|@|[|]|\\(|\\)|\\{|}|_|\\*|<|>|/|\"";

    public static Map<String, Integer> getWordsOnPage(String url) {
        String text = getText(url);
        String[] wordsArr = getWords(text);
        setWords(wordsArr);
        return words;
    }

    private static String getText(String url) {
        Document page;
        try {
            page = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        return page.text();
    }

    private static String[] getWords(String text) {
        return text.split(delimiters);
    }

    private static void setWords(String[] wordsArr) {
        for (String word: wordsArr) {
            if (words.get(word) == null) {
                words.put(word, 1);
            } else {
                int value = words.get(word);
                words.put(word, value + 1);
            }
        }
    }
}
