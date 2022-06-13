package com.example.bitcoinproject.api_client;

import com.example.bitcoinproject.spec.api_request.PathVariable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;

@Slf4j
public abstract class UpbitApiClient {

    public static final int MAXIMUM_COUNT = 200;
    public static final int UPBIT_BASE_HOUR = 9;
    public static final int UPBIT_BASE_MINUTE = 0;
    public static final int UPBIT_BASE_SECOND = 0;

    protected final RestTemplate restTemplate;

    protected URI baseUri;

    public UpbitApiClient(RestTemplate restTemplate, Environment env, PathVariable path) {
        this.restTemplate = restTemplate;
        try {
            this.baseUri = new URI(Objects.requireNonNull(env.getProperty("baseUri")).concat(path.getParamName()));
        } catch (URISyntaxException e) {
            log.error("URI syntax is wrong.");
        }
    }

    public <T> List<T> getResponse(URI uri, ParameterizedTypeReference<List<T>> parameterizedTypeReference) {
        return restTemplate.exchange(
                uri,
                HttpMethod.GET,
                null,
                parameterizedTypeReference).getBody();
    }

}
