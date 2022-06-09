package com.example.bitcoinproject.service;

import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;

import java.time.LocalDateTime;

public interface MinuteCandleCrawlingService {

    int crawMinuteCandlesAndSaveInDb(UnitType unit, MarketType market, LocalDateTime to, int days);

}
