package edu.matc.persistence;

import edu.matc.entity.Run;
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
    void updateSucess() {
        User userToUpdate = userDao.getById(1);

        userToUpdate.setUserName("newName");

        userDao.saveOrUpdate(userToUpdate);

        User updatedUser = userDao.getById(1);

        assertEquals(userToUpdate, updatedUser);
    }

    @Test
    void insertSuccess() {
        User newUser = new User("Bob", "Miller", "bmiller");

        int id =  userDao.insert(newUser);

        User retrievedUser = userDao.getById(id);
        assertEquals("Bob", retrievedUser.getFirstName());
        assertEquals("Miller", retrievedUser.getLastName());
        assertEquals("bmiller", retrievedUser.getUserName());
    }

    @Test
    void deleteSuccess() {
        User userToDelete = userDao.getById(2);
        userDao.delete(userToDelete);
        User retrievedUser = userDao.getById(2);
        assertNull(retrievedUser);
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

    @Test
    void deleteWithRuns() {
        User userToDelete = userDao.getById(1);

        List<Run> runs = userToDelete.getRuns();

        int runId1 = runs.get(0).getId();
        int runId2 = runs.get(1).getId();

        userDao.delete(userToDelete);

        assertNull(userDao.getById(1));

        RunDao runDao = new RunDao();

        assertNull(runDao.getById(runId1));
        assertNull(runDao.getById(runId2));
    }

}