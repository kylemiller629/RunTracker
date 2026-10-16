package edu.matc.controller;

import edu.matc.entity.Run;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Controller for displaying runs
 *
 * @author kmiller
 */
@WebServlet("/viewRuns")
public class ViewRuns extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (userId == null) {
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }


        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(userId);


        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }

        List<Run> runs = user.getRuns();

        int totalRuns = runs.size();
        double totalDistance = user.calculateTotalDistance();

        request.setAttribute("totalRuns", totalRuns);
        request.setAttribute("totalDistance", totalDistance);
        request.setAttribute("runs", runs);

        request.getRequestDispatcher("/runs.jsp").forward(request, response);
    }
}
