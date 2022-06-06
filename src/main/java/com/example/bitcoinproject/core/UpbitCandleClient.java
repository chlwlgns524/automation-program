package com.example.bitcoinproject.core;

import com.example.bitcoinproject.dto.MinuteCandleDTO;
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
public class UpbitCandleClient {

    private final RestTemplate restTemplate;

    private URI baseUri;

    public UpbitCandleClient(Environment env, RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
        try {
            this.baseUri = new URI(Objects.requireNonNull(env.getProperty("baseUri")));
        } catch (URISyntaxException e) {
            log.error("URI syntax is wrong.");
        }
//
    }

    public List<MinuteCandleDTO> getMinuteCandles(@NonNull UnitType unit, @NonNull MarketType market, int count, LocalDateTime to) {
        return restTemplate.exchange(
                UriAppender.getCandleUriForMinutes(baseUri, unit, market, count, to),
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<MinuteCandleDTO>>(){}).getBody();
    }

}
