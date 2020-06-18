package ru.itis.counter.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Аспект для логирования поиска новой веб-страницы
 * */

@Aspect
@Component
@Slf4j
public class AfterSearchingPageAspect {


    @AfterThrowing("execution(* ru.itis.counter.utils.PageSavingUtil.savePage(..))")
    public void searchingError() {
        log.error("Can't find specified page " + LocalDateTime.now().toString());
    }

    @After("execution(* ru.itis.counter.utils.PageSavingUtil.savePage(..))")
    public void searchSuccessful() {
        log.info("Searching successful " + LocalDateTime.now().toString());
    }
}
