package edu.matc.controller;


import edu.matc.entity.Run;
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

        int id  = Integer.parseInt(request.getParameter("id"));

        RunDao runDao = new RunDao();
        Run run = runDao.getById(id);

        request.setAttribute("run",run);

        request.getRequestDispatcher("/runDetails.jsp").forward(request,response);

    }

}
