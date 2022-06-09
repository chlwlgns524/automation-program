package com.example.bitcoinproject.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AppTerminator {

    private final ApplicationContext applicationContext;

    public void terminate() {
        System.exit(SpringApplication.exit(applicationContext, () -> 100));
    }

}
