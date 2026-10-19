package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Weather;
import edu.matc.util.PropertiesLoader;
import org.apache.logging.log4j.LogManager;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WeatherDao  implements PropertiesLoader {

    private final Logger logger = LogManager.getLogger(this.getClass().getName());

    public Weather getWeather(double latitude, double longitude) throws Exception {

        Properties properties  = loadProperties("/weather.properties");
        String url = properties.getProperty("weather.api.url");

        Client client = ClientBuilder.newClient();


        try {
            WebTarget target = client.target(url)
                    .queryParam("latitude", latitude)
                    .queryParam("longitude", longitude)
                    .queryParam("current", "temperature_2m,wind_speed_10m")
                    .queryParam("temperature_unit", "fahrenheit")
                    .queryParam("wind_speed_unit", "mph");

            logger.info("attempting to fetch weather data");

            String response = target.request(MediaType.APPLICATION_JSON)
                            .get(String.class);

            ObjectMapper mapper = new ObjectMapper();
            Weather weather = mapper.readValue(response, Weather.class);

            logger.info("successfully fetched weather data");

            return weather;

        } catch (Exception e) {
            logger.error("Error retrieving weather", e);
        } finally {
            client.close();
        }

    }
}
