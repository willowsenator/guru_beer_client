package com.willowsenator.guru_beer_client.web.model.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class BeerClientTest {

    @Autowired
    BeerClient client;

    @Test
    void getBeerDto() {
        var dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }
}