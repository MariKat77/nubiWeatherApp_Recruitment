package com.nubisoft.nubiweather.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nubisoft.nubiweather.models.ForecastCityRecord;
import com.nubisoft.nubiweather.models.ForecastResponse;
import com.nubisoft.nubiweather.models.WeatherRecord;
import com.nubisoft.nubiweather.models.WeatherResponse;

@Service
public class WeatherService {

    @Value("${weatherapi.apikey}")
    private String apiKey;

    @Value("${weatherapi.baseurl}")
    private String baseUrl;

    private final HashMap<String, WeatherRecord> realtimeWeatherCache = new HashMap<>();
    private final HashMap<String, ForecastCityRecord> forecastWeatherCache = new HashMap<>();

    private RestTemplate restTemplate = new RestTemplate();

    public WeatherRecord getRealtimeWeather() {
        String gliwiceUrl = baseUrl + "current.json?key=" + apiKey + "&q=Gliwice";
        String hamburgUrl = baseUrl + "current.json?key=" + apiKey + "&q=Hamburg";

        WeatherResponse gliwiceResponse = restTemplate.getForObject(gliwiceUrl, WeatherResponse.class);
        WeatherResponse hamburgResponse = restTemplate.getForObject(hamburgUrl, WeatherResponse.class);

        String time = gliwiceResponse.location().localtime();  //key to HashMap
        realtimeWeatherCache.put(time, new WeatherRecord(List.of(gliwiceResponse, hamburgResponse)));

        return new WeatherRecord(List.of(gliwiceResponse, hamburgResponse));
    }

    public ForecastCityRecord getForecastWeather() {
        String gliwiceUrl = baseUrl + "forecast.json?key=" + apiKey + "&q=Gliwice&days=7";
        String hamburgUrl = baseUrl + "forecast.json?key=" + apiKey + "&q=Hamburg&days=7";

        ForecastResponse gliwiceResponse = restTemplate.getForObject(gliwiceUrl, ForecastResponse.class);
        ForecastResponse hamburgResponse = restTemplate.getForObject(hamburgUrl, ForecastResponse.class);

        String time = gliwiceResponse.location().localtime();  //key to HashMap
        forecastWeatherCache.put(time, new ForecastCityRecord(List.of(gliwiceResponse, hamburgResponse)));

        return new ForecastCityRecord(List.of(gliwiceResponse, hamburgResponse));
    }

    public WeatherRecord getRealtimeWeatherCache(String key) {
        return realtimeWeatherCache.get(key);
    }

    public ForecastCityRecord getForecastWeatherCache(String key) {
        return forecastWeatherCache.get(key);
    }
}
