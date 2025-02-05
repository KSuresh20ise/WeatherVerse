package com.suresh.weatherverse;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Autowired
    private Environment env;
    @Value("${API_KEY}")
    private String apikey;

    @Value("${weatherstack.url}")
    private String Base_url;



    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Weather getWeather(String city){
        try {
            String apiUrl = Base_url+apikey+"&query="+city;
            String jsonResponse = restTemplate.getForObject(apiUrl,String.class);
            return objectMapper.readValue(jsonResponse,Weather.class);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
