package com.suresh.weatherverse;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;

@Component
@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {

    private Location location;
    private Current current;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Current getCurrent() {
        return current;
    }

    public void setCurrent(Current current) {
        this.current = current;
    }
}

// Location Class
@JsonIgnoreProperties(ignoreUnknown = true)
class Location {
    private String name;
    private String country;
    private String region;

    @JsonProperty("localtime")
    private String localtime;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getRegion() { return region; }
    public void setRegion(String region) { this.region = region; }

    public String getLocaltime() { return localtime; }
    public void setLocaltime(String localtime) { this.localtime = localtime; }
}

// Current Weather Class
@JsonIgnoreProperties(ignoreUnknown = true)
class Current {
    private String observation_time;
    private int temperature;
    private int weather_code;

    @JsonProperty("weather_icons")
    private String[] weatherIcons;

    @JsonProperty("weather_descriptions")
    private String[] weatherDescriptions;

    private int wind_speed;
    private int wind_degree;
    private String wind_dir;
    private int pressure;
    private int precip;
    private int humidity;
    private int cloudcover;
    private int feelslike;
    private int uv_index;
    private int visibility;

    // Getters and Setters
    public String getObservation_time() { return observation_time; }
    public void setObservation_time(String observation_time) { this.observation_time = observation_time; }

    public int getTemperature() { return temperature; }
    public void setTemperature(int temperature) { this.temperature = temperature; }

    public int getWeather_code() { return weather_code; }
    public void setWeather_code(int weather_code) { this.weather_code = weather_code; }

    public String[] getWeatherIcons() { return weatherIcons; }
    public void setWeatherIcons(String[] weatherIcons) { this.weatherIcons = weatherIcons; }

    public String[] getWeatherDescriptions() { return weatherDescriptions; }
    public void setWeatherDescriptions(String[] weatherDescriptions) { this.weatherDescriptions = weatherDescriptions; }

    public int getWind_speed() { return wind_speed; }
    public void setWind_speed(int wind_speed) { this.wind_speed = wind_speed; }

    public int getWind_degree() { return wind_degree; }
    public void setWind_degree(int wind_degree) { this.wind_degree = wind_degree; }

    public String getWind_dir() { return wind_dir; }
    public void setWind_dir(String wind_dir) { this.wind_dir = wind_dir; }

    public int getPressure() { return pressure; }
    public void setPressure(int pressure) { this.pressure = pressure; }

    public int getPrecip() { return precip; }
    public void setPrecip(int precip) { this.precip = precip; }

    public int getHumidity() { return humidity; }
    public void setHumidity(int humidity) { this.humidity = humidity; }

    public int getCloudcover() { return cloudcover; }
    public void setCloudcover(int cloudcover) { this.cloudcover = cloudcover; }

    public int getFeelslike() { return feelslike; }
    public void setFeelslike(int feelslike) { this.feelslike = feelslike; }

    public int getUv_index() { return uv_index; }
    public void setUv_index(int uv_index) { this.uv_index = uv_index; }

    public int getVisibility() { return visibility; }
    public void setVisibility(int visibility) { this.visibility = visibility; }
}
