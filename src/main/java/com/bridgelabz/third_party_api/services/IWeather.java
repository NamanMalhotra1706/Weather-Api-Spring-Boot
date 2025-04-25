package com.bridgelabz.third_party_api.services;

import org.springframework.http.ResponseEntity;

import com.bridgelabz.third_party_api.dtos.ResponseDTO;

public interface IWeather {
	ResponseEntity<ResponseDTO> getWeatherByCity(String city);
	
}
