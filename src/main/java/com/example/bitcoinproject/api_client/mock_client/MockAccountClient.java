package com.example.bitcoinproject.api_client.mock_client;

import com.example.bitcoinproject.dto.AccountDTO;
import com.example.bitcoinproject.spec.api_request.Ticker;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MockAccountClient {

    private AccountDTO mockedKrw;
    private AccountDTO mockedBtc;

    public MockAccountClient() {
        mockedKrw = new AccountDTO();
        mockedKrw.setCurrency(Ticker.KRW.toString());
        mockedKrw.setBalance("100000000.0");

        mockedBtc = new AccountDTO();
        mockedBtc.setCurrency(Ticker.BTC.toString());
        mockedBtc.setBalance("0.0");
    }

    public List<AccountDTO> getAccount() {
        return List.of(mockedKrw, mockedBtc);
    }

}
