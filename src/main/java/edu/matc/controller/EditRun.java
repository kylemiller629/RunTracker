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
 * Controller for editing a run
 *
 * @author kmiller
 */
@WebServlet("/editRun")
public class EditRun extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userId = (Integer)request.getSession().getAttribute("userId");

        if (userId == null) {
            response.sendRedirect(request.getContextPath()+"/logIn");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        RunDao runDao = new RunDao();
        Run run = runDao.getById(id);

        if (run == null || run.getUser() == null || run.getUser().getId() != userId) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        request.setAttribute("run", run);

        request.getRequestDispatcher("/editRun.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userId = (Integer)request.getSession().getAttribute("userId");

        if (userId == null) {
            response.sendRedirect(request.getContextPath()+"/logIn");
            return;
        }

        int id;

        try {
            id = Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        String runDate = request.getParameter("runDate");
        String distance = request.getParameter("distance");
        String duration = request.getParameter("duration");
        String notes = request.getParameter("notes");

        RunDao runDao = new RunDao();
        Run run = runDao.getById(id);

        if (run == null || run.getUser() == null || run.getUser().getId() != userId) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        run.setRunDate(LocalDate.parse(runDate));
        run.setDistance(Double.parseDouble(distance));
        run.setDuration(Integer.parseInt(duration));
        run.setNotes(notes);

        runDao.saveOrUpdate(run);

        response.sendRedirect("viewRuns");

    }

}
