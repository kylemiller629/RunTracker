package edu.matc.controller;

import edu.matc.entity.GoalProgress;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for viewing a user's goals
 *
 * @author kmiller
 */
@WebServlet("/viewGoals")
public class ViewGoals extends HttpServlet {

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
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }


        List<GoalProgress> goalProgressList = user.getGoalProgressList();

        request.setAttribute("goalProgressList", goalProgressList);

        request.getRequestDispatcher("/goals.jsp").forward(request, response);
    }
}
