package com.example.bitcoinproject.app.core.crawler;

import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;

import java.time.LocalDateTime;
import java.util.List;

public interface MinuteCandleCrawling {

    List<CandleDTO> crawl(UnitType unit, MarketType market, LocalDateTime to, int days);

}
