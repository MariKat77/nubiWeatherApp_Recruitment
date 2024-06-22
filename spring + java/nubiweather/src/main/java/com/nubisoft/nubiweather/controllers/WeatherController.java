package com.nubisoft.nubiweather.controllers;

import com.nubisoft.nubiweather.models.ForecastRecord;
import com.nubisoft.nubiweather.models.WeatherRecord;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/realtime-weather")
    public WeatherRecord getRealtimeWeather() {
        return weatherService.getRealtimeWeather();
    }

    @GetMapping("/forecast-weather")
    public ForecastRecord getForecastWeather() {
        return weatherService.getForecastWeather();
    }
}
