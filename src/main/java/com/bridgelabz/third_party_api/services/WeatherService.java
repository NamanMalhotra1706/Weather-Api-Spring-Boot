package com.bridgelabz.third_party_api.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.bridgelabz.third_party_api.dtos.ResponseDTO;
import com.bridgelabz.third_party_api.dtos.WeatherDTO;
import org.springframework.web.client.RestTemplate;


@Service
public class WeatherService implements IWeather {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public ResponseEntity<ResponseDTO> getWeatherByCity(String city) {


		String api = "https://api.openweathermap.org/data/2.5/weather?q=" +city+ "&appid=3b6120103a2f219e04d2ca9168fd5c91&units=metric";


		try {


			// Make API call and get the full response as String
			String fullResponse = restTemplate.getForObject(api, String.class);

			// Parse the JSON response using Jackson
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(fullResponse);

			// Extracting required values from the JSON response
			String cityName = node.get("name").asText(); // e.g., "Mumbai"
			String country = node.get("sys").get("country").asText(); // e.g., "IN"
			String weather = node.get("weather").get(0).get("main").asText(); // e.g., "Clouds"
			String temp = node.get("main").get("temp").asText(); // e.g., "28.25"
			String feelsLike = node.get("main").get("feels_like").asText(); // e.g., "30.87"

			// Create WeatherDTO and set extracted values
			WeatherDTO weatherDTO = new WeatherDTO();
			weatherDTO.setCityName(cityName);
			weatherDTO.setCountry(country);
			weatherDTO.setWeather(weather);
			weatherDTO.setTemp(temp);
			weatherDTO.setFeelsLike(feelsLike);


			return new ResponseEntity<>(new ResponseDTO("Weather fetched successfully", weatherDTO), HttpStatus.OK);
		} catch (JsonProcessingException e) {

			return new ResponseEntity<>(new ResponseDTO("Error parsing weather data", null), HttpStatus.BAD_REQUEST);
		} catch (RuntimeException e) {

			return new ResponseEntity<>(new ResponseDTO("Internal Server Error", null), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
