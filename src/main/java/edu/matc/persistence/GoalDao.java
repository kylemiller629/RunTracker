package edu.matc.persistence;

import edu.matc.entity.Goal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GoalDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Gets a goal by its id
     * @param id goal id
     * @return goal
     */
    public Goal getGoalById(int id) {
        Session session = sessionFactory.openSession();
        Goal goal = (Goal) session.get(Goal.class, id);
        session.close();
        return goal;
    }
}
