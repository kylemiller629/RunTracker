package edu.matc.controller;


import edu.matc.entity.Run;
import edu.matc.persistence.GenericDao;
import edu.matc.persistence.RunDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;
import java.io.IOException;

/**
 * Controller for viewing details of a run
 *
 * @author kmiller
 */
@WebServlet("/runDetails")
public class RunDetails extends HttpServlet {

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
        }  catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        GenericDao<Run> runDao = new GenericDao<>(Run.class);

        Run run = runDao.getById(id);

        if (run == null || run.getUser() == null || run.getUser().getId() != userId) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }
        request.setAttribute("run",run);

        request.getRequestDispatcher("/runDetails.jsp").forward(request,response);

    }

}
