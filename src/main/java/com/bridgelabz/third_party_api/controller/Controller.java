package com.bridgelabz.third_party_api.controller;


import com.bridgelabz.third_party_api.dtos.ResponseDTO;
import com.bridgelabz.third_party_api.dtos.WeatherDTO;
import com.bridgelabz.third_party_api.services.IWeather;
import com.bridgelabz.third_party_api.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Slf4j
public class Controller {


	@Autowired
	private IWeather weatherService;

	@GetMapping
	public String healthCheck() {
		log.info("Health check started");
		return "API working";
	}

	@GetMapping("/get-weather")
	public ResponseEntity<ResponseDTO> getWeather(@RequestParam String city) {
		return weatherService.getWeatherByCity(city);
	}
}

