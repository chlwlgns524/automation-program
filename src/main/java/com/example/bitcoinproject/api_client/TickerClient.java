package com.example.bitcoinproject.api_client;

import com.example.bitcoinproject.dto.TickerDTO;
import com.example.bitcoinproject.spec.api_request.MarketType;
import com.example.bitcoinproject.spec.api_request.PathVariable;
import com.example.bitcoinproject.utils.UriAppender;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class TickerClient extends UpbitApiClient {

    private final ParameterizedTypeReference<List<TickerDTO>> parameterizedTypeReference = new ParameterizedTypeReference<>() {};

    @Autowired
    public TickerClient(RestTemplate restTemplate, Environment env) {
        super(restTemplate, env, PathVariable.TICKER);
    }

    public List<TickerDTO> getCurrentTicker(@NonNull MarketType market) {
        return getResponse(UriAppender.getCurrentTickerUri(baseUri, market),
                parameterizedTypeReference);
    }

}
