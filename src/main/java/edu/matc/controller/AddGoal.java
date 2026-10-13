package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.UserDao;
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

        goal.setGoalType(goalType);
        goal.setTarget(Double.parseDouble(target));
        goal.setStartDate(LocalDate.parse(startDate));
        goal.setEndDate(LocalDate.parse(endDate));

        UserDao userDao = new UserDao();
        User user = userDao.getById(userId);

        if (user == null) {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }

        goal.setUser(user);

        GoalDao goalDao = new GoalDao();
        goalDao.insert(goal);

        response.sendRedirect("viewGoals");
    }
}
