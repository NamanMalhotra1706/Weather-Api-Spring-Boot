package com.bridgelabz.third_party_api.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WeatherDTO {
	String cityName;
	String country;
	String weather;
	String temp;
	String feelsLike;
	
}
