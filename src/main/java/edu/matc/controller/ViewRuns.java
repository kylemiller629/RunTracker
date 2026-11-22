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
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for displaying runs
 *
 * @author kmiller
 */
@WebServlet("/viewRuns")
public class ViewRuns extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

        String searchDate = request.getParameter("searchDate");

        List<Run> filteredRuns = new ArrayList<>();

        if (searchDate != null && !searchDate.isEmpty()) {

            try {

                LocalDate date = LocalDate.parse(searchDate);

                for (Run run : user.getRuns()) {

                    if (run.getRunDate().equals(date)) {
                        filteredRuns.add(run);
                    }
                }

            } catch (DateTimeParseException exception) {

                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please enter a valid search date.");
                return;
            }

        } else {

            filteredRuns.addAll(user.getRuns());
        }

        request.setAttribute("user", user);
        request.setAttribute("filteredRuns", filteredRuns);
        request.setAttribute("searchDate", searchDate);

        request.getRequestDispatcher("/runs.jsp").forward(request, response);
    }
}
