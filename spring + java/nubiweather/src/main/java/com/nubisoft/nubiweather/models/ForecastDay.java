package com.nubisoft.nubiweather.models;

public record ForecastDay(double maxtemp_c,
        double mintemp_c,
        double avgtemp_c,
        double maxwind_kph,
        double totalprecip_mm,
        double totalsnow_cm,
        double avgvis_km,
        int avghumidity,
        int daily_will_it_rain,
        int daily_chance_of_rain,
        int daily_will_it_snow,
        int daily_chance_of_snow,
        double uv) {

}
