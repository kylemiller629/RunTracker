package edu.matc.controller;

import edu.matc.entity.Goal;
import edu.matc.entity.User;
import edu.matc.persistence.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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

        UserDao userDao = new UserDao();
        User user = userDao.getById(userId);

        if (user == null) {
            request.getSession().invalidate();
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }

        List<Goal> goals = user.getGoals();
        request.setAttribute("goals", goals);
        request.getRequestDispatcher("goals.jsp").forward(request, response);
    }
}
