package com.suresh.weatherverse;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    @Value("${API_KEY}")
    private String apikey;

    @Value("${weatherstack.url}")
    private String Base_url;




    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public Object getWeather(String city){
        try {
            String apiUrl = Base_url+apikey+"&query="+city;
            String jsonResponse = restTemplate.getForObject(apiUrl,String.class);
            JsonNode rootNode = objectMapper.readTree(jsonResponse);
            if (rootNode.has("success") && !rootNode.get("success").asBoolean()){
                return objectMapper.treeToValue(rootNode,WeatherError.class);
            }
            return objectMapper.readValue(rootNode.toString(),Weather.class);

        } catch (Exception e) {
            e.printStackTrace();
            return new WeatherError(false, new WeatherError.ErrorDetail(500, "Internal Server Error"));
        }
    }

}
