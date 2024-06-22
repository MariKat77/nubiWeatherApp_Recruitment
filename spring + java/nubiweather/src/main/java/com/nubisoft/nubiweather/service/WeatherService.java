package com.nubisoft.nubiweather.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.nubisoft.nubiweather.models.ForecastLocationRecord;
import com.nubisoft.nubiweather.models.ForecastRecord;
import com.nubisoft.nubiweather.models.WeatherRecord;
import com.nubisoft.nubiweather.models.WeatherResponse;

@Service
public class WeatherService {

    @Value("${weatherapi.apikey}")
    private String apiKey;

    @Value("${weatherapi.baseurl}")
    private String baseUrl;

    private RestTemplate restTemplate = new RestTemplate();

    public WeatherRecord getRealtimeWeather() {
        String gliwiceUrl = baseUrl + "current.json?key=" + apiKey + "&q=Gliwice";
        String hamburgUrl = baseUrl + "current.json?key=" + apiKey + "&q=Hamburg";

        WeatherResponse gliwiceResponse = restTemplate.getForObject(gliwiceUrl, WeatherResponse.class);
        WeatherResponse hamburgResponse = restTemplate.getForObject(hamburgUrl, WeatherResponse.class);

        return new WeatherRecord(List.of(gliwiceResponse, hamburgResponse));
    }

    public ForecastRecord getForecastWeather() {
        String gliwiceUrl = baseUrl + "forecast.json?key=" + apiKey + "&q=Gliwice&days=7";
        String hamburgUrl = baseUrl + "forecast.json?key=" + apiKey + "&q=Hamburg&days=7";

        ForecastLocationRecord gliwiceResponse = restTemplate.getForObject(gliwiceUrl, ForecastLocationRecord.class);
        ForecastLocationRecord hamburgResponse = restTemplate.getForObject(hamburgUrl, ForecastLocationRecord.class);

        return new ForecastRecord(List.of(gliwiceResponse, hamburgResponse));
    }
}
