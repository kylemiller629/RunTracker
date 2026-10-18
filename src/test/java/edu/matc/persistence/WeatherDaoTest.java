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

    }
}