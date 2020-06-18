package ru.itis.counter.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AfterWordsReportSavingAspect {

    @After("execution(* ru.itis.counter.services.impls.PagesServiceImpl.getOne(..))")
    public void searchingError() {
        log.info("Report saved at " + LocalDateTime.now().toString());
    }
}
