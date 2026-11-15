package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;
import edu.matc.entity.Goal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Controller for adding a goal
 *
 * @author kmiller
 */
@WebServlet("/addGoal")
public class AddGoal  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (userId == null) {
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }

        String goalType = request.getParameter("goalType");
        String target = request.getParameter("target");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        Goal goal = new Goal();

        try {

            goal.setGoalType(goalType);
            goal.setTarget(Double.parseDouble(target));
            goal.setStartDate(LocalDate.parse(startDate));
            goal.setEndDate(LocalDate.parse(endDate));

            if (goalType == null || goalType.trim().isEmpty()) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please select a goal type.");
                return;
            }

            if (goal.getTarget() <= 0 || !Double.isFinite(goal.getTarget())) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Goal target must be greater than zero.");
                return;
            }

            if (goal.getEndDate().isBefore(goal.getStartDate())) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "End date cannot be before start date.");
                return;
            }

        } catch (RuntimeException exception) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please enter a valid target and dates.");
            return;
        }

        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(userId);

        if (user == null) {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }

        user.addGoal(goal);

        GenericDao<Goal> goalDao = new GenericDao<>(Goal.class);

        goalDao.insert(goal);

        response.sendRedirect("viewGoals");
    }
}
