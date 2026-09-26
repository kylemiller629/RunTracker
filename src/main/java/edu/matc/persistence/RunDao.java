package edu.matc.persistence;

import edu.matc.entity.Run;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Data access class to CRUD runs.
 * @author kmiller
 */
public class RunDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get run by id
     * @param id run id
     * @return run
     */
    public Run getById(int id) {
        logger.info("getById" + id);
        Session session = sessionFactory.openSession();

        Run run = session.get(Run.class, id);
        session.close();
        return run;
    }

    /**
     * Update a run.
     *
     * @param run Run to be updated
     */
    public void saveOrUpdate(Run run) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.merge(run);
        tx.commit();
        session.close();
    }

}
