package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Weather;
import edu.matc.util.PropertiesLoader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;


public class WeatherDao  implements PropertiesLoader {

    public Weather getWeather() throws Exception {

        Properties properties  = loadProperties("/weather.properties");

        String url = properties.getProperty("weather.api.url");

        Client client = ClientBuilder.newClient();

        WebTarget target = client.target(url);

        String response = target.request(MediaType.APPLICATION_JSON)
                .get(String.class);

        ObjectMapper mapper = new ObjectMapper();

        Weather weather = null;

        try {
            weather = mapper.readValue(response, Weather.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            // TODO set up logging
        }

        return weather;
    }
}
