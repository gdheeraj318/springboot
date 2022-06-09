package com.guru.springframework.web.client;

import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.guru.springframework.web.model.BeerDto;

@Component
@ConfigurationProperties(value="sfg.brewery",ignoreUnknownFields = false)
public class BreweryClient {
	
	private String BEER_PATH_V1 = "/api/v1/beer/";
	private String apihost;

	private final RestTemplate restTemplate;
	
	public BreweryClient(RestTemplateBuilder restTempBuilder) {
		this.restTemplate = restTempBuilder.build();
	}
	
	public void setApihost(String apihost) {
		this.apihost = apihost;
	}
	
	
	public BeerDto getBeerById(UUID uuid) {
		return restTemplate.getForObject(apihost+BEER_PATH_V1+uuid.toString(), BeerDto.class);
	}
}
