package edu.matc.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.matc.entity.Response;
import edu.matc.util.PropertiesLoader;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Controller that retrieves a location based from a zip and returns its latitude and longitude
 *
 * @author kmiller
 */
public class LocationDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    private String url;
    private String username;

    public LocationDao(String url, String username) {
        this.url = url;
        this.username = username;
    }

    public Response getLocation(String zipCode) throws Exception {


        Client client = ClientBuilder.newClient();

        try {
            WebTarget target = client.target(url)
                    .queryParam("postalcode", zipCode)
                    .queryParam("country", "US")
                    .queryParam("username", username);

            logger.info("Attempting to retrieve location for ZIP: " + zipCode);

            String response = target.request(MediaType.APPLICATION_JSON_TYPE).get(String.class);

            ObjectMapper mapper = new ObjectMapper();

            Response location = mapper.readValue(response, Response.class);

            logger.info("Succesffuly retrieved location");

            return location;

        } catch (WebApplicationException e) {
            logger.error("GeoNames API returned an HTTP error: " + e.getResponse().getStatus(), e);
            throw e;
        } catch (JsonProcessingException e) {
            logger.error("Unable to parse GeoNames JSON response", e);
            throw e;
        } catch (Exception e) {
            logger.error("Error retrieving location for zipcode: " + zipCode, e);
            throw e;
        } finally {
            client.close();
        }
    }

}
