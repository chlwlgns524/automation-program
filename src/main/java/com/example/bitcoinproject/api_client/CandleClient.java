package com.example.bitcoinproject.api_client;

import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.api_request.MarketType;
import com.example.bitcoinproject.spec.api_request.PathVariable;
import com.example.bitcoinproject.spec.api_request.UnitType;
import com.example.bitcoinproject.utils.UriAppender;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class CandleClient extends UpbitApiClient {

    private final ParameterizedTypeReference<List<CandleDTO>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};

    @Autowired
    public CandleClient(RestTemplate restTemplate, Environment env) {
        super(restTemplate, env, PathVariable.CANDLES);
    }

    public List<CandleDTO> getMinuteCandles(@NonNull UnitType unit, @NonNull MarketType market, int count, LocalDateTime to) {
        return getResponse(UriAppender.getCandleUriForMinutes(baseUri, unit, market, count, to),
                parameterizedTypeReference);
    }

    public List<CandleDTO> getDayCandles(@NonNull MarketType market, int count, LocalDateTime to) {
        return getResponse(UriAppender.getCandleUriForDays(baseUri, market, count, to),
                parameterizedTypeReference);
    }

}
