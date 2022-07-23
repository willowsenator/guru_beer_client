package com.willowsenator.guru_beer_client.web.model.client;

import com.willowsenator.guru_beer_client.web.model.BeerDto;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(value = "com.willowsenator.brewery", ignoreUnknownFields = false)
public class BeerClient {
    private String apiHost;
    public final String BEER_V1_PATH = "/api/v1/beer/";
    private final RestTemplate restTemplate;

    public BeerClient(RestTemplateBuilder restTemplateBuilder){
        restTemplate = restTemplateBuilder.build();
    }
    public void setApiHost(String apiHost) {
        this.apiHost = apiHost;
    }

    public BeerDto getBeerById(UUID uuid){
        return restTemplate.getForObject(apiHost + BEER_V1_PATH + uuid.toString(), BeerDto.class);
    }

    public URI saveNewBeer(BeerDto beerDto){
        return restTemplate.postForLocation(apiHost + BEER_V1_PATH, beerDto);
    }

    public void updateBeer(UUID uuid, BeerDto beerDto){
        restTemplate.put(apiHost+ BEER_V1_PATH + uuid.toString(), beerDto);
    }
}
