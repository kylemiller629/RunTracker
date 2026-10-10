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
 * Controller for deleting a run.
 *
 * @author kmiller
 */
@WebServlet("/deleteRun")
public class DeleteRun  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        RunDao runDao = new RunDao();

        Run run = runDao.getById(id);

        if (run != null){
            runDao.delete(run);
        }

        response.sendRedirect("viewRuns");

    }
}
