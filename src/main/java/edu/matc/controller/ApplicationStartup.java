package edu.matc.controller;

import edu.matc.util.PropertiesLoader;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.util.Properties;

/**
 * Loads Cognito properties when the application starts.
 */
@WebServlet(
        name = "applicationStartup",
        urlPatterns = { "/application-startup" },
        loadOnStartup = 1
)
public class ApplicationStartup extends HttpServlet implements PropertiesLoader {

    /**
     * Loads properties and stores them in ServletContext
     * @throws ServletException servlet exception
     */
    @Override
    public void init() throws ServletException {

        ServletContext context = getServletContext();

        try {
            Properties properties = loadProperties("/cognito.properties");
            context.setAttribute("cognitoProperties", properties);

            Properties weatherProperties = loadProperties("/weather.properties");
            context.setAttribute("weatherProperties", weatherProperties);

            Properties geonamesProperties = loadProperties("/geonames.properties");
            context.setAttribute("geonamesProperties", geonamesProperties);
        } catch (Exception e) {
            throw new ServletException(e);
        }


    }
}
