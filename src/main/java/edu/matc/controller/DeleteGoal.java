package edu.matc.controller;

import edu.matc.entity.Goal;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.GoalDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller for deleting a goal
 *
 * @author kmiller
 */
@WebServlet("/deleteGoal")
public class DeleteGoal extends HttpServlet {

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
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        GenericDao<Goal> goalDao = new GenericDao<>(Goal.class);
        Goal goal = goalDao.getById(id);

        if  (goal == null || goal.getUser() == null ||  goal.getUser().getId() != userId) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        goalDao.delete(goal);

        response.sendRedirect(request.getContextPath() + "/viewGoals");
    }
}
