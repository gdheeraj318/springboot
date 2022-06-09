package com.guru.springframework;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.guru.springframework.web.client.BreweryClient;
import com.guru.springframework.web.model.BeerDto;

@SpringBootTest
public class BreweryClientTest {
	
	@Autowired
	BreweryClient client;
	@Test
	void getBeerById() {
		BeerDto beerDto = client.getBeerById(UUID.randomUUID());
		assertNotNull(beerDto);
	}

}
