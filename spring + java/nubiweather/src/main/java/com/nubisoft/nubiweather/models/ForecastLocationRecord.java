package com.nubisoft.nubiweather.models;

import java.util.List;

public record ForecastLocationRecord(String location, List<ForecastResponse> forecastLocation) {

}
