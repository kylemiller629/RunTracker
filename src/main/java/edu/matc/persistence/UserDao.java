package edu.matc.persistence;

import edu.matc.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

/**
 * Provides database access methods for User entities
 *
 * @author kmiller
 */
public class UserDao {


    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get user by id
     * @return user
     * @param id user id
     */
    public User getById(int id) {
        logger.info("getById" + id);
        Session session = sessionFactory.openSession();
        User user = session.get( User.class, id );
        session.close();
        return user;
    }

    /**
     * Saves or updates a user
     *
     * @param user user to save or update
     */
    public void saveOrUpdate(User user) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.merge(user);
        tx.commit();
        logger.info("saveOrUpdate" + user);
        session.close();
    }

    /**
     * Inserts a user
     *
     * @param user user to insert
     * @return the new user's id
     */
    public int insert(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        int id = (int) session.save(user);
        tx.commit();

        logger.info("insert" + user);

        session.close();
        return id;
    }

    /**
     * Deletes a user
     *
     * @param user user to delete
     */
    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.delete(user);
        tx.commit();
        logger.info("delete" + user.getId());
        session.close();
    }


    /**
     * Gets a user by their username
     *
     * @param userName username to search
     * @return the matching user or null if not found
     */
    public User getByUserName(String userName) {
        Session session = sessionFactory.openSession();

        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);

        Root<User> root = cq.from(User.class);
        cq.select(root).where(cb.equal(root.get("userName"), userName));

        List<User> list = session.createQuery(cq).getResultList();

        session.close();
        if (list.isEmpty()) {
            return null;
        }

        return list.get(0);
    }

    /**
     * Gets all users.
     *
     * @return list of users
     */
    public List<User> getAll() {
        logger.info("getting all users");
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);

        cq.from(User.class);

        List<User> users = session.createQuery(cq).getResultList();
        session.close();
        return users;
    }

}
