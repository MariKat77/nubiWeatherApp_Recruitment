# nubiWeatherApp_Recruitment

## Table of contents

- [General info](#general-info)
- [Technologies](#technologies)
- [Setup](#setup)

## General info

This project is a simple API that uses [WeatherAPI.com](https://www.weatherapi.com/) to show current weather in Gliwice and Hamburg. The application was built in Spring Boot framework. It exposes two endpoints, which response on GET method:

- `/api/realtime-weather` - returns current weather in Gliwice and Hamburg
- `/api/forecast-weather` - returns forecast for next seven days in Gliwice and Hamburg (numer of forecast days can be change in WeatherService.java in method getForecastWeather())

API returns only information in metrics units, but it can be change with loging to the [WeatherAPI.com](https://www.weatherapi.com/login.aspx) and going to settings and change the fields which are returning from this API.

If you have already your account on this site [WeatherAPI.com](https://www.weatherapi.com/) and you have your own API key you can switch it to your own key in the file `spring + java\nubiweather\src\main\resources\application.properties`.

## Technologies

Project is created with:

- Java 21
- Spring Boot

## Setup

To run this project, you must first clone this repository and next using gradlew build project and run:

```
$ cd .\nubiWeatherApp_Recruitment\'spring + java'\nubiweather
$ ./gradlew build
$ ./gradlew bootRun
```

Command `./gradlew build` - builds application and perform tests\
Command `./gradlew bootRun` - runs this project as a Spring Boot application\
Other commands you can achieve with command: `./gradlew task`.

In some cases the standard port 8080 is already in usage then we must perform following commands in privilege mode CMD:

```
netstat -o -a
```

which shows us, the tasks and usage ports with PID. Then we must find PID of task which use 8080 port and kill this task with following command:

```
taskkill /pid PID_OF_PROCESS /F
```

Then run bootRun command again.
