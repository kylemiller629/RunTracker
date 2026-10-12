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
 * Controller to retrieve the logged in user's miles
 *
 * @author kmiller
 */
@WebServlet("/dashboard")
public class Dashboard  extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer userId = (Integer)req.getSession().getAttribute("userId");

        if (userId == null){
            resp.sendRedirect(req.getContextPath()+"/logIn");
            return;
        }

        RunDao runDao = new RunDao();
        List<Run> runs = runDao.getByUserId(userId);

        int totalRuns = runs.size();
        double totalDistance = 0;

        for (Run run : runs){
            totalDistance += run.getDistance();
        }

        req.setAttribute("totalRuns", totalRuns);
        req.setAttribute("totalDistance", totalDistance);
        req.setAttribute("runs", runs);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
