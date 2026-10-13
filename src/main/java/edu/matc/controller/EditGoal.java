package edu.matc.controller;


import edu.matc.entity.Goal;
import edu.matc.persistence.GoalDao;

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

        GoalDao goalDao = new GoalDao();
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

        GoalDao goalDao = new GoalDao();
        Goal goal = goalDao.getById(id);

        if (goal == null || goal.getUser() == null || goal.getUser().getId() != userId) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String goalType = request.getParameter("goalType");
        String target =  request.getParameter("target");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");

        goal.setGoalType(goalType);
        goal.setTarget(Double.parseDouble(target));
        goal.setStartDate(LocalDate.parse(startDate));
        goal.setEndDate(LocalDate.parse(endDate));

        goalDao.saveOrUpdate(goal);

        response.sendRedirect("viewGoals");

    }
}
