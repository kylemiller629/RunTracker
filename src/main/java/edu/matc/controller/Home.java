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
 * Controller for the MileMarker home page
 *
 * @author kmiller
 */
@WebServlet("/home")
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RunDao runDao = new RunDao();
        List<Run> runs = runDao.getAll();

        int totalRuns = runs.size();

        double totalDistance = 0;

        for (Run run: runs) {
            totalDistance += run.getDistance();
        }

        request.setAttribute("runs", runs);
        request.setAttribute("totalRuns", totalRuns);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

}
