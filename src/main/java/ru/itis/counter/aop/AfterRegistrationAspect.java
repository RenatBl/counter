package ru.itis.counter.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Aspect
@Component
@Slf4j
public class AfterRegistrationAspect {

    @After("execution(* ru.itis.counter.services.impls.SignUpServiceImpl.signUp(..))")
    public void signUpLog() {
        log.info("New user has sign up " + LocalDateTime.now().toString());
    }

    @AfterThrowing("execution(* ru.itis.counter.services.impls.SignUpServiceImpl.signUp(..))")
    public void exceptionLog() {
        log.error("User couldn't sign up " + LocalDateTime.now().toString());
    }
}
