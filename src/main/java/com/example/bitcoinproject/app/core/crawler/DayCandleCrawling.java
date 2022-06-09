package com.example.bitcoinproject.app.core.crawler;

import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.MarketType;

import java.time.LocalDateTime;
import java.util.List;

public interface DayCandleCrawling {

    List<CandleDTO> crawl(MarketType market, LocalDateTime to, int days);

}
