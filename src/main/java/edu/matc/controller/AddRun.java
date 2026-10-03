package edu.matc.controller;

import edu.matc.entity.Run;
import edu.matc.persistence.RunDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Controller for adding a run
 *
 * @author kmiller
 */
@WebServlet("/addRun")
public class AddRun extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String runDate = request.getParameter("runDate");
        String distance = request.getParameter("distance");
        String duration = request.getParameter("duration");
        String notes  = request.getParameter("notes");

        Run run = new Run();

        run.setRunDate(LocalDate.parse(runDate));
        run.setDistance(Double.parseDouble(distance));
        run.setDuration(Integer.parseInt(duration));
        run.setNotes(notes);

        RunDao runDao = new RunDao();
        runDao.insert(run);

        response.sendRedirect("viewRuns");
    }
}
