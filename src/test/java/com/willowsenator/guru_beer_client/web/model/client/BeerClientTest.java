package com.willowsenator.guru_beer_client.web.model.client;

import com.willowsenator.guru_beer_client.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

@SpringBootTest
class BeerClientTest {

    @Autowired
    BeerClient client;

    @Test
    void getBeerById() {
        var dto = client.getBeerById(UUID.randomUUID());
        assertNotNull(dto);
    }

    @Test
    void saveNewBeer(){
        var dto = BeerDto.builder().beerName("New Beer").build();
        var uri = client.saveNewBeer(dto);
        assertNotNull(uri);
        System.out.println(uri);
    }

    @Test
    void updateBeer() {
        try {
            var dto = BeerDto.builder().beerName("New Beer").build();
            client.updateBeer(UUID.randomUUID(), dto);
        }
        catch(Exception ex){
            fail(ex.getMessage());
        }
    }

    @Test
    void deleteBeer() {
        try{
            client.deleteBeer(UUID.randomUUID());
        }
        catch(Exception ex){
            fail(ex.getMessage());
        }
    }

}