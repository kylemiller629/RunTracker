package edu.matc.controller;

import edu.matc.entity.Goal;
import edu.matc.entity.GoalProgress;
import edu.matc.entity.Run;
import edu.matc.entity.User;
import edu.matc.persistence.RunDao;
import edu.matc.persistence.UserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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

        List<Run> recentRuns = runs;

        if (runs.size() > 5) {
            recentRuns = runs.subList(0, 5);
        }

        UserDao userDao = new UserDao();
        User user = userDao.getById(userId);

        if (user == null) {
            req.getSession().invalidate();
            resp.sendRedirect(req.getContextPath()+"/logIn");
            return;
        }

        int totalRuns = runs.size();
        double totalDistance = user.calculateTotalDistance();

        List<Goal> goals = user.getGoals();

        List<GoalProgress> goalProgressList = new ArrayList<>();

        for (Goal goal : goals) {
            double progress = goal.calculateProgress(runs);
            goalProgressList.add(new GoalProgress(goal, progress));
        }

        req.setAttribute("totalRuns", totalRuns);
        req.setAttribute("totalDistance", totalDistance);
        req.setAttribute("runs", runs);
        req.setAttribute("goalProgressList", goalProgressList);
        req.setAttribute("recentRuns", recentRuns);

        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
