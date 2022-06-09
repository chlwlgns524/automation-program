package com.example.bitcoinproject.aop.terminate;

import com.example.bitcoinproject.configuration.AppTerminator;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Aspect
public class TerminateAdvice {

    private final AppTerminator appTerminator;

    @AfterReturning(value = "@annotation(com.example.bitcoinproject.aop.terminate.Terminal)")
    public void terminateApplicationRighAfterReturning() {
        System.out.println("terminateApplicationRighAfterReturning() called!");

        appTerminator.terminate();
    }

}
