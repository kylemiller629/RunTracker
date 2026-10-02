package edu.matc.persistence;

import edu.matc.entity.Goal;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

    /**
     * Saves or updates a goal
     * @param goal
     */
    public void saveOrUpdate(Goal goal) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.merge(goal);
        tx.commit();
        session.close();
    }

    /**
     * Inserts a new goal into the db
     * @param goal goal to insert
     * @return new goals id
     */
    public int insert(Goal goal) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        int id = (Integer) session.save(goal);

        tx.commit();
        session.close();

        logger.info("Goal " + goal.getId() + " has been saved successfully");
        return id;
    }
}
