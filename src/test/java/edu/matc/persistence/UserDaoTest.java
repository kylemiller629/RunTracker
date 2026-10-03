package edu.matc.persistence;

import edu.matc.entity.Goal;
import edu.matc.entity.Run;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
/**
 *Tests the UserDao database
 *
 * @author kmiller
 */
class UserDaoTest {

    UserDao userDao;

    /**
     *Resets the db and creates a UserDao before each test.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        userDao = new UserDao();
    }

    /**
     * Tests retrieving a user by id
     */
    @Test
    void getByIdSuccess() {
        User user = userDao.getById(1);

        assertEquals("Kyle", user.getFirstName());
        assertEquals("Miller", user.getLastName());
        assertEquals("kmiller", user.getUserName());
    }

    /**
     * Tests updating an existing user
     */
    @Test
    void updateSuccess() {
        User userToUpdate = userDao.getById(1);

        userToUpdate.setUserName("newName");

        userDao.saveOrUpdate(userToUpdate);

        User updatedUser = userDao.getById(1);

        assertEquals(userToUpdate, updatedUser);
    }

    /**
     * Tests inserting a new user
     */
    @Test
    void insertSuccess() {
        User newUser = new User("Bob", "Miller", "bmiller");

        int id =  userDao.insert(newUser);

        User retrievedUser = userDao.getById(id);
        assertEquals(newUser, retrievedUser);

    }

    /**
     * Tests deleting a user
     */
    @Test
    void deleteSuccess() {
        User userToDelete = userDao.getById(2);
        userDao.delete(userToDelete);
        User retrievedUser = userDao.getById(2);
        assertNull(retrievedUser);
    }

    /**
     * Tests getting all users
     */
    @Test
    void getAllSuccess() {
        List<User> user = userDao.getAll();

        assertEquals(2, user.size());
    }

    /**
     * Tests retriving the runs associated with a user
     */
    @Test
    void getRunsSuccess() {
        User user = userDao.getById(1);
        assertEquals(2, user.getRuns().size());
    }

    /**
     * Tests deleting a user and their associated runs
     */
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

    /**
     * Tests inserting a user with associated runs.
     */
    @Test
    void insertWithRuns() {
        User newUser = new User("Kyle", "Miller", "bmiller");

        Run run1 = new Run(LocalDate.of(2026, 9,28), 3.1, 1440, "Easy Run");

        Run run2 = new Run(LocalDate.of(2026, 9,29), 5.0, 2250, "Morning Run");

        newUser.addRun(run1);
        newUser.addRun(run2);

        int id = userDao.insert(newUser);

        User retrievedUser = userDao.getById(id);

        assertEquals(2, retrievedUser.getRuns().size());
    }

    /**
     * Tests getting a users goal
     */
    @Test
    void getGoalsSuccess() {
        User user = userDao.getById(1);
        assertEquals(2, user.getGoals().size());
    }

    /**
     *Tests inserting a user with goals
     */
    @Test
    void insertWithGoals() {
        User newUser = new User("Blake", "Miller", "blakemiller");

        Goal goal1 = new Goal("Weekly Distance", 30.00, LocalDate.of(2026, 10,5), LocalDate.of(2026, 10,11));

        Goal goal2 = new Goal("Monly Distance", 120.0, LocalDate.of(2026, 10,1), LocalDate.of(2026, 10,31));

        newUser.addGoal(goal1);
        newUser.addGoal(goal2);

        int id = userDao.insert(newUser);

        User retrievedUser = userDao.getById(id);
        assertEquals(2, retrievedUser.getGoals().size());
    }

    /**
     * Tests deleting a user with goals
     */
    @Test
    void deleteWithGoals() {
        User userToDelete = userDao.getById(1);

        List<Goal> goals = userToDelete.getGoals();

        int goalId1 = goals.get(0).getId();
        int goalId2 = goals.get(1).getId();

        userDao.delete(userToDelete);

        assertNull(userDao.getById(1));

        GoalDao goalDao = new GoalDao();

        assertNull(goalDao.getById(goalId1));
        assertNull(goalDao.getById(goalId2));
    }


}