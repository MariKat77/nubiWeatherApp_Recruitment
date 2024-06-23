package com.nubisoft.nubiweather.models;

public record ForecastResponse(WeatherLocationRecord location, CurrentWeatherRecord current, ForecastRecord forecast) {

}
