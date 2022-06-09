package com.example.bitcoinproject.app;

import com.example.bitcoinproject.aop.terminate.Terminal;
import com.example.bitcoinproject.app.core.backtester.BackTester;
import com.example.bitcoinproject.app.core.crawler.Crawler;
import com.example.bitcoinproject.app.core.trader.Trader;
import com.example.bitcoinproject.configuration.ApplicationMode;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "!test")
@RequiredArgsConstructor
@Component
public class MainApplication implements ApplicationRunner {
    private final ApplicationMode mode;

    private final Crawler crawler;
    private final BackTester backTester;
    private final Trader trader;

    @Terminal
    @Override
    public void run(ApplicationArguments args) throws Exception {
        switch (mode.getApplicationMode()) {
            case CRAWL -> crawler.run();
            case BACK_TEST -> backTester.run();
            case TRADE -> trader.run();
        }
    }

}
