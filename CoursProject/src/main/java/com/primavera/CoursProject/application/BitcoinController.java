package com.primavera.CoursProject.application;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

@Component
public class BitcoinController {
	private final RestTemplate restTemplate;
    private final String REQUEST_URI = "https://stockmarkettrading.azurewebsites.net/stocks/bitcoins";
    public BitcoinController(RestTemplate restTemplate) {
    	this.restTemplate = restTemplate;
    }
    
    public double buyBitcoins(double amount) {

        ObjectMapper mapper = new ObjectMapper();
        ObjectNode data = mapper.createObjectNode();
        data.put("groupId",  "primavera");
        data.put("amount", amount);
    	String response = restTemplate.postForObject(REQUEST_URI,data, String.class);
    	System.out.println(response);
    	try {
			return getPrice(response);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    }

	private double getPrice(String response) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
	    JsonNode node = mapper.readTree(response);
		return node.path("unitPriceInEur").asDouble();
	}

}
