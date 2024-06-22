package com.nubisoft.nubiweather.models;

public record WeatherLocationRecord(String name,
        String region,
        String country,
        double lat,
        double lon,
        String tz_id,
        int localtime_epoch,
        String localtime) {

}
