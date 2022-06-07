package com.example.bitcoinproject.aop.terminate;

import com.example.bitcoinproject.aop.terminate.Terminal;
import com.example.bitcoinproject.app.AppTerminator;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Aspect
public class TerminateAdvice {

    private final AppTerminator appTerminator;

    @AfterReturning(value = "@annotation(terminal)")
    public void terminateApplicationRighAfterReturning(Terminal terminal) {
        System.out.println("terminateApplicationRighAfterReturning() called!");

        appTerminator.terminate();
    }

}
