package ru.itis.counter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import ru.itis.counter.utils.PageSavingUtil;
import ru.itis.counter.utils.WordsFindingUtil;

import java.io.File;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@SpringBootTest
public class CounterApplicationTests {

    @Test
    public void testSavePage() {
        PageSavingUtil.savePage("https://www.simbirsoft.com/");
        boolean isExist = new File("D:/pages/simbirsoft.html").exists();

        assertTrue(isExist);
    }

    @Test
    public void testGettingWords() {
        Map<String, Integer> words = WordsFindingUtil.getWordsOnPage("https://www.simbirsoft.com/");

        assertFalse(words.isEmpty());
    }
}
