package com.example.bitcoinproject.service;

import com.example.bitcoinproject.spec.MarketType;

import java.time.LocalDateTime;

public interface DayCandleCrawlingService {

    int crawDayCandlesAndSaveInDb(MarketType market, LocalDateTime to, int days);

}
