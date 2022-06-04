package com.example.bitcoinproject;

import com.example.bitcoinproject.dto.MinuteCandle;
import lombok.NonNull;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class UpbitCandleClient {

    private String baseUri;

    private final RestTemplate restTemplate;

    public UpbitCandleClient(Environment environment, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        this.baseUri = environment.getProperty("baseUri");
    }

    public List<MinuteCandle> getMinuteCandles(@NonNull int unit, @NonNull MarketType market, int count, LocalDateTime to) {
        return restTemplate.exchange(
                getAppendedUri(PathNameForUnit.PATH_MINUTES, unit, market, count, to),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MinuteCandle>>(){}).getBody();
    }

    //https://api.upbit.com/v1/candles/minutes/5?market=KRW-BTC&count=200&to=2022-05-31%2010:00:00
    private URI getAppendedUri(PathNameForUnit pathNameForUnit, int unit, MarketType market, int count, LocalDateTime to) {
        StringBuilder fullPath = new StringBuilder()
                .append(pathNameForUnit.getPathName())
                .append(unit);

        try {
            return new URI(UriComponentsBuilder.newInstance()
                    .uri(new URI(baseUri))
                    .path(fullPath.toString())
                    .queryParam("market", market.getValue())
                    .queryParam("count", count)
//                    .queryParam("to",to.toString()) -> should be refactored after understanding.
                    .build(true).toString());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return null;
    }

}
