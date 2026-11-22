package edu.matc.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handles requests to the home page.
 * Redirects authenticated users to the dashboard and
 * forwards unauthenticated users to the index page.
 *
 * @author kmiller
 */
@WebServlet("/home")
public class Home extends HttpServlet {

    /**
     * Handles GET requests to the home page.
     *
     * @param req the HTTP request
     * @param resp the HTTP response
     * @throws ServletException if a servlet error occurs
     * @throws IOException if an input or output error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = (Integer)req.getSession().getAttribute("userId");

        if (userId != null) {
            resp.sendRedirect(req.getContextPath()+"/dashboard");
            return;
        }

        req.getRequestDispatcher("/index.jsp").forward(req, resp);

    }
}
