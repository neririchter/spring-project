package com.oran.springProject.client;

import com.oran.springProject.client.dto.CurrencyObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;

@Slf4j
@Component
public class CurrencyClient {

    @Value("${currency.key}")
    private String key;

    private final RestTemplate restTemplate;

    public CurrencyClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void getCurrency(){
        UriComponents build = UriComponentsBuilder.fromHttpUrl("https://api.apilayer.com/fixer/latest")
                .build();

        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("apikey", Collections.singletonList(key));

        HttpEntity<Void> httpEntity = new HttpEntity<>(headers);

        ResponseEntity<CurrencyObject> exchange = restTemplate.exchange(build.toUri(), HttpMethod.GET, httpEntity, CurrencyObject.class);
        CurrencyObject body = exchange.getBody();
        log.info("currency: {}",  body);
    }
}
