package edu.matc.controller;

import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

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

        request.setAttribute("user", user);
        request.getRequestDispatcher("/runs.jsp").forward(request, response);
    }
}
