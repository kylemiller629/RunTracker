package edu.matc.persistence;

import edu.matc.entity.Weather;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeatherDaoTest {

    @Test
    void getWeatherSuccess()  throws Exception {
        WeatherDao dao = new WeatherDao();
        Weather weather = dao.getWeather();

        assertNotNull(weather);
        assertNotNull(weather.getCurrent());

        // verify location returned by the API
        assertEquals(43.07, (Double) weather.getLatitude(), 0.1);
        assertEquals(-89.40, (Double) weather.getLongitude(), 0.1);

        // verify weather data is in reasonable range
        double temperature = weather.getCurrent().getTemperature2m();
        double windSpeed = weather.getCurrent().getWindSpeed10m();

        assertTrue(temperature > -150 && temperature < 150);
        assertTrue(windSpeed >= 0);

        // verify units are returned by the API
        assertNotNull(weather.getCurrent());
        assertEquals("°F", weather.getCurrentUnits().getTemperature2m());
        assertEquals("mph", weather.getCurrentUnits().getWindSpeed10m());

    }
}