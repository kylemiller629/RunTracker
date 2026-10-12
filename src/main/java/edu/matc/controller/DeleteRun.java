package edu.matc.controller;
import edu.matc.entity.Run;
import edu.matc.persistence.RunDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Controller for deleting a run.
 *
 * @author kmiller
 */
@WebServlet("/deleteRun")
public class DeleteRun  extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer userId = (Integer)request.getSession().getAttribute("userId");

        if (userId == null) {
            response.sendRedirect(request.getContextPath() + "/logIn");
            return;
        }

        int id;

        try {
            id =  Integer.parseInt(request.getParameter("id"));
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        RunDao runDao = new RunDao();
        Run run = runDao.getById(id);

        if (run == null || run.getUser() == null || run.getUser().getId() != userId) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        runDao.delete(run);
        response.sendRedirect(request.getContextPath() + "/viewRuns");

    }
}
