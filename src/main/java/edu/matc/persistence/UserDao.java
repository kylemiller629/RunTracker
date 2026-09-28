package edu.matc.persistence;

import edu.matc.entity.User;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Root;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class UserDao {


    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    /**
     * Get user by id
     * @return user
     * @param id user id
     */
    public User getById(int id) {
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
        session.close();
    }

    /**
     * Inserts a user
     *
     * @param user user to insert
     * @return the ner user's id
     */
    public int insert(User user) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        int id = (int) session.save(user);
        tx.commit();
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
        session.close();
    }

    /**
     * Gets all users.
     *
     * @return list of users
     */
    public List<User> getAll() {
        Session session = sessionFactory.openSession();
        CriteriaBuilder cb = sessionFactory.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);

        cq.from(User.class);

        List<User> users = session.createQuery(cq).getResultList();
        session.close();
        return users;
    }

}
