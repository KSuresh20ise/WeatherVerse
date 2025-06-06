package com.suresh.weatherverse;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
@CrossOrigin(origins = "*") // Allow frontend requests
public class WeatherController {

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/{city}")
    public Object getWeather(@PathVariable String city){
        System.out.println(weatherService.getWeather(city));
        return weatherService.getWeather(city);
    }
}
