package edu.matc.controller;

import edu.matc.entity.Run;
import edu.matc.persistence.RunDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Controller for displaying runs
 *
 * @author kmiller
 */
@WebServlet("/viewRuns")
public class ViewRuns extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RunDao runDao = new RunDao();

        List<Run> runs = runDao.getAll();

        request.setAttribute("runs", runs);

        request.getRequestDispatcher("/runs.jsp").forward(request, response);
    }
}
