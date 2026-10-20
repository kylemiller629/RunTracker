package edu.matc.controller;

import edu.matc.entity.Response;
import edu.matc.entity.PostalCodesItem;
import edu.matc.persistence.LocationDao;
import edu.matc.entity.User;
import edu.matc.entity.Weather;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.WeatherDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller to retrieve the logged in user's display information
 *
 * @author kmiller
 */
@WebServlet("/dashboard")
public class Dashboard  extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Integer userId = (Integer)req.getSession().getAttribute("userId");

        if (userId == null){
            resp.sendRedirect(req.getContextPath()+"/logIn");
            return;
        }


        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(userId);

        if (user == null) {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath()+"/logIn");
            return;
        }

        req.setAttribute("user", user);

        String zipCode = req.getParameter("zipCode");
        LocationDao locationDao = new LocationDao();
        WeatherDao weatherDao = new WeatherDao();

        try {
            Response locationResponse = locationDao.getLocation(zipCode);

            if (locationResponse.getPostalCodes() != null && !locationResponse.getPostalCodes().isEmpty()) {

                PostalCodesItem location = locationResponse.getPostalCodes().get(0);

                double latitude = location.getLat();
                double longitude = location.getLng();

                Weather weather = weatherDao.getWeather(latitude, longitude);
                req.setAttribute("weather", weather);
                req.setAttribute("location", location);


            }
        } catch (Exception e) {
            logger.error("unable to retrieve weather data", e);
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
