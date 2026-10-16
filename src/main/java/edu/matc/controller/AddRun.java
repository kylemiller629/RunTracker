package edu.matc.controller;

import edu.matc.entity.Run;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;


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

        Integer userId = (Integer)request.getSession().getAttribute("userId");
        if (userId == null){
            response.sendRedirect(request.getContextPath()+"/logIn");
            return;
        }
        String runDate = request.getParameter("runDate");
        String distance = request.getParameter("distance");
        String duration = request.getParameter("duration");
        String notes  = request.getParameter("notes");

        Run run = new Run();

        run.setRunDate(LocalDate.parse(runDate));
        run.setDistance(Double.parseDouble(distance));
        run.setDuration(Integer.parseInt(duration));
        run.setNotes(notes);

        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(userId);

        if (user == null) {
            response.sendRedirect(request.getContextPath()+"/logIn");
            return;
        }

        user.addRun(run);

        GenericDao<Run> runDao = new GenericDao<>(Run.class);

        runDao.insert(run);

        response.sendRedirect("viewRuns");
    }
}
