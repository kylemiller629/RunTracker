package edu.matc.persistence;

import edu.matc.entity.Goal;
import edu.matc.entity.Run;
import edu.matc.entity.User;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class GenericDaoTest {

    GenericDao<Run> runDao;

    /**
     * Resets the database before each test
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");

        runDao = new GenericDao<>(Run.class);
    }

    /**
     * Tests retrieving a run by its ID
     */
    @Test
    void getByIdSuccess() {
        Run run = runDao.getById(1);

        assertNotNull(run);
        assertEquals(1, run.getId());
        assertEquals(5.0, run.getDistance(), 0.01);
    }

    /**
     * Tests retrieving all runs from the database
     */
    @Test
    void getAllSuccess() {
        List<Run> runs = runDao.getAll();

        assertNotNull(runs);
        assertEquals(3, runs.size());
    }

    /**
     * Tests inserting a new run into the database.
     */
    @Test
    void insertSuccess() {
        Run run = new Run();

        run.setRunDate(LocalDate.of(2026, 10, 15));
        run.setDistance(5.0);
        run.setDuration(1800);
        run.setNotes("Test");

        int id = runDao.insert(run);

        Run insertedRun = runDao.getById(id);
        assertNotNull(insertedRun);
        assertEquals(5.0, insertedRun.getDistance(), 0.01);
        assertEquals(1800, insertedRun.getDuration());
        assertEquals("Test", insertedRun.getNotes());
    }

    /**
     * Tests updating an existing run
     */
    @Test
    void updateSuccess() {
        Run run = runDao.getById(1);

        run.setDistance(7.0);
        run.setNotes("Updated");

        runDao.update(run);

        Run updatedRun = runDao.getById(1);

        assertEquals(7.0, updatedRun.getDistance(), 0.01);
        assertEquals("Updated", updatedRun.getNotes());
    }

    /**
     * Tests deleting a run from the database
     */
    @Test
    void deleteSuccess() {
        Run run = runDao.getById(1);

        assertNotNull(run);

        runDao.delete(run);

        Run deletedRun = runDao.getById(1);
        assertNull(deletedRun);
    }

    /**
     * Tests finding an entity by one of its properties.
     */
    @Test
    void findByPropertyEqualSuccess() {
        List<Run> runs = runDao.findByPropertyEqual("distance", 5.0);

        assertNotNull(runs);
        assertEquals(1, runs.size());
        assertEquals(5.0, runs.get(0).getDistance(), 0.01);
    }

    /**
     * Tests retrieving a user GenericDao
     */
    @Test
    void getUserByIdSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);

        User user = userDao.getById(1);
        assertNotNull(user);
        assertEquals(1, user.getId());
    }

    /**
     * Tests inserting and retrieving a goal using GenericDao
     */
    @Test
    void insertGoalsSuccess() {
        GenericDao<Goal> goalDao = new GenericDao<>(Goal.class);

        Goal goal = new Goal("Weekly Distance", 20.0, LocalDate.of(2026, 10, 12),LocalDate.of(2026, 10, 18));

        int id = goalDao.insert(goal);

        Goal insertedGoal = goalDao.getById(id);
        assertNotNull(insertedGoal);
        assertEquals("Weekly Distance", insertedGoal.getGoalType());

    }

    /**
     * Tests finding a user by username
     */
    @Test
    void findUserByUserNameSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);

        User user = userDao.getById(1);

        List<User> users = userDao.findByPropertyEqual("userName", user.getUserName());

        assertEquals(1, users.size());
        assertEquals(user.getId(), users.get(0).getId());
    }

    /**
     * Tests that deleting a run does not delete its user
     */
    @Test
    void deleteRunDoesNotDeleteUser() {
        GenericDao<User> userDao = new GenericDao<>(User.class);

        Run runToDelete = runDao.getById(1);

        int userId = runToDelete.getUser().getId();

        runDao.delete(runDao.getById(1));
        assertNotNull(userDao.getById(userId));
    }

    /**
     * Tests retrieving the runs associated with a user
     */
    @Test
    void getUserRunsSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);

        User user = userDao.getById(1);

        assertNotNull(user);
        assertEquals(2, user.getRuns().size());
    }
    /**
     * Tests retrieving the goals associated with a user
     */
    @Test
    void getUserGoalsSucccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);

        User user = userDao.getById(1);

        assertNotNull(user);
        assertEquals(2, user.getGoals().size());
    }

    /**
     * Tests inserting a user with associated runs
     */
    @Test
    void insertUserWithRunsSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);

        User newUser = new User("Kyle", "Miller", "test");

        Run run1 = new Run(LocalDate.of(2026, 9, 28), 3.1, 1440, "Easy Run");

        Run run2 = new Run(LocalDate.of(2026, 9, 29), 5.0, 2250, "Morning Run");

        newUser.addRun(run1);
        newUser.addRun(run2);

        int id = userDao.insert(newUser);

        User retrievedUser = userDao.getById(id);
        assertNotNull(retrievedUser);
        assertEquals(2, retrievedUser.getRuns().size());

    }

    /**
     * Tests inserting a user with associated goals
     */
    @Test
    void insertedUserWithGoalsSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User newUser = new User("Kyle", "Miller", "test");

        Goal goal1 = new Goal("Weekly Distance", 30.0, LocalDate.of(2026, 10, 5), LocalDate.of(2026, 10, 11));
        Goal goal2 = new Goal("Monthly Distance", 120.0, LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 31));

        newUser.addGoal(goal1);
        newUser.addGoal(goal2);

        int id = userDao.insert(newUser);
        User retrievedUser = userDao.getById(id);
        assertNotNull(retrievedUser);
        assertEquals(2, retrievedUser.getGoals().size());
    }

    /**
     * Tests deleting a user and their associated runs
     */
    @Test
    void deleteUserWithRunsSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User userToDelete = userDao.getById(1);

        List<Run> runs = userToDelete.getRuns();

        int runId1 = runs.get(0).getId();
        int runId2 = runs.get(1).getId();

        userDao.delete(userToDelete);

        assertNull(runDao.getById(runId1));
        assertNull(runDao.getById(runId2));
    }

    /**
     * Tests deleting a user and their associated run
     */
    @Test
    void deleteUserWithGoalsSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        GenericDao<Goal> goalDao = new GenericDao<>(Goal.class);

        User userToDelete = userDao.getById(1);

        List<Goal> goals = userToDelete.getGoals();

        int goalId1 = goals.get(0).getId();
        int goalId2 = goals.get(1).getId();

        userDao.delete(userToDelete);

        assertNull(userDao.getById(1));
        assertNull(goalDao.getById(goalId1));
        assertNull(goalDao.getById(goalId2));

    }

    /**
     * Tests updating an existing user
     */
    @Test
    void updateUserSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user = userDao.getById(1);

        user.setUserName("new name");

        userDao.update(user);
        User updatedUser = userDao.getById(1);
        assertEquals("new name", updatedUser.getUserName());
    }

    /**
     * Tests inserting a new user
     */
    @Test
    void insertUserSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);

        User newUser = new User("Kyle", "Miller", "test");

        int id = userDao.insert(newUser);

        User retrievedUser = userDao.getById(id);

        assertNotNull(retrievedUser);
        assertEquals("Kyle", retrievedUser.getFirstName());
        assertEquals("Miller", retrievedUser.getLastName());
        assertEquals("test", retrievedUser.getUserName());
    }

    /**
     * Tests retrieving all users from the database
     */
    @Test
    void getAllUsersSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);

        List<User> users = userDao.getAll();

        assertNotNull(users);
        assertEquals(2, users.size());
    }

    /**
     * Tests deleting a user from the database
     */
    @Test
    void deleteUserSuccess() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User userToDelete = userDao.getById(2);

        assertNotNull(userToDelete);

        userDao.delete(userToDelete);

        User deletedUser = userDao.getById(2);

        assertNull(deletedUser);


    }
}
