package com.nubisoft.nubiweather.models;

public record WeatherResponse(String location, double temp, double humidt, double windSpeed) {

}
