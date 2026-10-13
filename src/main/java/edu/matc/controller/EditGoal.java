package edu.matc.controller;


import edu.matc.entity.Goal;
import edu.matc.persistence.GoalDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller for editing a run
 *
 * @author kmiller
 */
@WebServlet("/editGoal")
public class EditGoal  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userId = (Integer) request.getSession().getAttribute("userID");

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
}
