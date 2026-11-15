package edu.matc.controller;

import edu.matc.entity.Goal;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Controller for editing a goal
 *
 * @author kmiller
 */
@WebServlet("/editGoal")
public class EditGoal  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (userId == null) {
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        GenericDao<Goal> goalDao = new GenericDao<>(Goal.class);
        Goal goal = goalDao.getById(id);

        if (goal == null || goal.getUser() == null || goal.getUser().getId() != userId) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        request.setAttribute("goal", goal);
        request.getRequestDispatcher("/editGoal.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (userId == null) {
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException ex) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        GenericDao<Goal> goalDao = new GenericDao<>(Goal.class);
        Goal goal = goalDao.getById(id);

        if (goal == null || goal.getUser() == null || goal.getUser().getId() != userId) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String goalType = request.getParameter("goalType");
        String target =  request.getParameter("target");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        try {

            double targetValue = Double.parseDouble(target);
            LocalDate startDateValue = LocalDate.parse(startDate);
            LocalDate endDateValue = LocalDate.parse(endDate);

            if (goalType == null || goalType.trim().isEmpty()) {

                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please select a goal type.");
                return;
            }

            if (targetValue <= 0 || !Double.isFinite(targetValue)) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Goal target must be greater than zero.");
                return;
            }

            if (endDateValue.isBefore(startDateValue)) {
                response.sendError(HttpServletResponse.SC_BAD_REQUEST, "End date cannot be before start date.");
                return;
            }

            goal.setGoalType(goalType);
            goal.setTarget(targetValue);
            goal.setStartDate(startDateValue);
            goal.setEndDate(endDateValue);

        } catch (RuntimeException exception) {

            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Please enter a valid target and dates.");
            return;
        }

        goalDao.update(goal);

        response.sendRedirect("viewGoals");

    }
}
