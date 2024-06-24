package com.nubisoft.nubiweather;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.nubisoft.nubiweather.models.ForecastCityRecord;
import com.nubisoft.nubiweather.models.WeatherRecord;
import com.nubisoft.nubiweather.service.WeatherService;

@SpringBootTest
class NubiweatherApplicationTests {

    @Autowired
    private WeatherService weatherService;

    @Test
    void testGetRealtimeWeather() {

        WeatherRecord response = weatherService.getRealtimeWeather();
        assertNotNull(response);
        assertEquals(2, response.weatherRecord().size());
        String gliwiceName = response.weatherRecord().get(0).location().name();
        assertNotNull(gliwiceName);
        assertEquals("Gliwice", gliwiceName);
        String hamburgName = response.weatherRecord().get(1).location().name();
        assertNotNull(hamburgName);
        assertEquals("Hamburg", hamburgName);
    }

    @Test
    public void testGetForecastWeather() {
        ForecastCityRecord response = weatherService.getForecastWeather();
        assertNotNull(response);
        assertEquals(2, response.forecastRecord().size());
        String gliwiceForecastName = response.forecastRecord().get(0).location().name();
        assertNotNull(gliwiceForecastName);
        assertEquals("Gliwice", gliwiceForecastName);
        String hamburgForecastName = response.forecastRecord().get(1).location().name();
        assertNotNull(hamburgForecastName);
        assertEquals("Hamburg", hamburgForecastName);
    }

    @Test
    public void testGetRealtimeWeatherCache() {
        WeatherRecord response = weatherService.getRealtimeWeather();
        WeatherRecord cache = weatherService.getRealtimeWeatherCache(response.weatherRecord().get(0).location().localtime());
        assertNotNull(cache);
        assertEquals(response, cache);
    }

    @Test
    public void testGetForecastWeatherCache() {
        ForecastCityRecord response = weatherService.getForecastWeather();
        ForecastCityRecord cache = weatherService.getForecastWeatherCache(response.forecastRecord().get(0).location().localtime());
        assertNotNull(cache);
        assertEquals(response, cache);
    }
}
