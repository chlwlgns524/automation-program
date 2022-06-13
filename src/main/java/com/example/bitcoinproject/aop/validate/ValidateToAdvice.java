package com.example.bitcoinproject.aop.validate;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Component
@Aspect
public class ValidateToAdvice {

    @After(value = "@annotation(com.example.bitcoinproject.aop.validate.CheckTimeParam)")
    public void isValidTo(JoinPoint joinPoint) {
        boolean valid = isValidTime((LocalDateTime) Arrays.stream(joinPoint.getArgs())
                .filter(o -> o instanceof LocalDateTime)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("to should exists!")));

        if (!valid)
            throw new IllegalArgumentException("Invalid to!");
    }

    private boolean isValidTime(LocalDateTime to) {
        return to.compareTo(LocalDateTime.now()) < 0;
    }

}
