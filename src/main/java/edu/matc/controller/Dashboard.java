package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.entity.Weather;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.WeatherDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        private final Logger logger = LogManager.getLogger(this.getClass());

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

        WeatherDao weatherDao = new WeatherDao();

        try {
            Weather weather = weatherDao.getWeather();
            req.setAttribute("weather", weather);
        } catch (Exception e) {
            logger.error("unable to retieve weather data", e);
        }

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
