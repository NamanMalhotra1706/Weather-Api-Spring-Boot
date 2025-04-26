package com.bridgelabz.third_party_api.scheduler;

import com.bridgelabz.third_party_api.dtos.ResponseDTO;
import com.bridgelabz.third_party_api.services.IWeather;
import com.bridgelabz.third_party_api.services.WeatherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WeatherScheduler {

    @Autowired
    private IWeather weatherService;

    @Scheduled(fixedRate = 5000)
    public void getWeatherByCity() {
        String city = "rajpura";
        ResponseEntity<ResponseDTO> response =  weatherService.getWeatherByCity(city);
        log.info("response: " + response.getBody());

    }
}
