package edu.matc.persistence;

import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao userDao;

    /**
     *
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        userDao = new UserDao();
    }

    @Test
    void getByIdSuccess() {
        User user = userDao.getById(1);

        assertEquals("Kyle", user.getFirstName());
        assertEquals("Miller", user.getLastName());
        assertEquals("kmiller", user.getUserName());
    }

    @Test
    void saveOrUpdate() {
    }

    @Test
    void insert() {
    }

    @Test
    void delete() {
    }

    @Test
    void getAllSuccess() {
        List<User> user = userDao.getAll();

        assertEquals(2, user.size());
    }

    @Test
    void getRunsSuccess() {
        User user = userDao.getById(1);
        assertEquals(2, user.getRuns().size());
    }

}