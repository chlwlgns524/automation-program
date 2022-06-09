package com.example.bitcoinproject.app.core.crawler;

import com.example.bitcoinproject.dto.CandleDTO;
import com.example.bitcoinproject.spec.MarketType;
import com.example.bitcoinproject.spec.UnitType;
import com.example.bitcoinproject.utils.UriAppender;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Slf4j
@Component
public class CandleClient {

    public static final int MAXIMUM_COUNT = 200;

    private final RestTemplate restTemplate;

    private URI baseUri;

    public CandleClient(RestTemplate restTemplate, Environment env) {
        this.restTemplate = restTemplate;
        try {
            this.baseUri = new URI(Objects.requireNonNull(env.getProperty("info.baseUri")));
        } catch (URISyntaxException e) {
            log.error("URI syntax is wrong.");
        }
    }

    public List<CandleDTO> getMinuteCandles(@NonNull UnitType unit, @NonNull MarketType market, int count, LocalDateTime to) {
        return getCandles(UriAppender.getCandleUriForMinutes(baseUri, unit, market, count, to));
    }

    public List<CandleDTO> getDayCandles(@NonNull MarketType market, int count, LocalDateTime to) {
        return getCandles(UriAppender.getCandleUriForDays(baseUri, market, count, to));
    }

    private List<CandleDTO> getCandles(URI uri) {
        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<CandleDTO>>() {}).getBody();
    }

}
