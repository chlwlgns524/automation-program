package com.example.bitcoinproject.api_client.mock_client;

import com.example.bitcoinproject.dto.AccountDTO;
import com.example.bitcoinproject.spec.api_request.MarketType;
import com.example.bitcoinproject.spec.api_request.OrderType;
import com.example.bitcoinproject.spec.api_request.SideType;
import com.example.bitcoinproject.spec.api_request.Ticker;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class MockOrderClient {

    public void sendBidRequest(MarketType market, SideType side, String volume, String price, OrderType orderType, String identifier) {

    }

    public void sendAskRequest(MarketType market, SideType side, String volume, String price, OrderType orderType, String identifier) {

    }

}
