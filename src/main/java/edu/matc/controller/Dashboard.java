package edu.matc.controller;


import edu.matc.entity.GoalProgress;
import edu.matc.entity.Run;
import edu.matc.entity.User;
import edu.matc.persistence.GenericDao;

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


        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(userId);

        if (user == null) {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath()+"/logIn");
            return;
        }

        req.setAttribute("user", user);

        List<Run> runs = user.getRuns();

        List<Run> recentRuns = runs;

        if (runs.size() > 5) {
            recentRuns = runs.subList(0, 5);
        }



        int totalRuns = runs.size();

        List<GoalProgress> goalProgressList = user.getGoalProgressList();

        req.setAttribute("totalRuns", totalRuns);
        req.setAttribute("runs", runs);
        req.setAttribute("goalProgressList", goalProgressList);
        req.setAttribute("recentRuns", recentRuns);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
