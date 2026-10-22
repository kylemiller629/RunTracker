package edu.matc.persistence;

import edu.matc.entity.PostalCodesItem;
import edu.matc.entity.Response;
import edu.matc.util.PropertiesLoader;
import java.util.Properties;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationDaoTest {

    @Test
    void getLocation() throws Exception {
        PropertiesLoader loader = new PropertiesLoader() {};
        Properties properties = loader.loadProperties("/geonames.properties");

        LocationDao dao = new LocationDao(
                properties.getProperty("geonames.api.url"),
                properties.getProperty("geonames.username")
        );

        Response response = dao.getLocation("54166");

        assertNotNull(response);
        assertNotNull(response.getPostalCodes());
        assertFalse(response.getPostalCodes().isEmpty());

        PostalCodesItem location = response.getPostalCodes().get(0);
        assertEquals("54166", location.getPostalCode());
        assertEquals("Shawano", location.getPlaceName());
        assertEquals(44.785133, location.getLat(), 0.01);
        assertEquals(-88.603599, location.getLng(), 0.01);

    }
}