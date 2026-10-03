package edu.matc.persistence;

import edu.matc.entity.Goal;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoalDaoTest {

    GoalDao goalDao;

    /**
     *Resets the db and creates a GoalrDao before each test.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        goalDao = new GoalDao();
    }

    /**
     * Tests getting a goal by id
     */
    @Test
    void getByIdSuccess() {
        Goal retrievedGoal = goalDao.getById(1);

        assertEquals("Weekly Distance", retrievedGoal.getGoalType());
        assertEquals(25.0, retrievedGoal.getTarget());
        assertEquals(LocalDate.of(2026, 9, 21), retrievedGoal.getStartDate());
        assertEquals(LocalDate.of(2026, 9, 27), retrievedGoal.getEndDate());
    }

    /**
     * Tests updating a goal
     */
    @Test
    void updateSuccess() {
        Goal goalToUpdate = goalDao.getById(1);

        goalToUpdate.setTarget(30.0);

        goalDao.saveOrUpdate(goalToUpdate);

        Goal retrievedGoal = goalDao.getById(1);

        assertEquals(goalToUpdate, retrievedGoal);
    }

    /**
     * Tests inserting a new goal
     */
    @Test
    void insertSuccess() {
        Goal newGoal = new Goal("Weekly Distance", 40.0, LocalDate.of(2026, 10, 5), LocalDate.of(2026, 10, 11));

        int id = goalDao.insert(newGoal);

        Goal retrievedGoal = goalDao.getById(id);

        assertEquals(newGoal, retrievedGoal);
    }

    /**
     * Tests deleting a goal
     */
    @Test
    void delete() {
        Goal goalToDelete = goalDao.getById(1);
        goalDao.delete(goalToDelete);
        Goal retrievedGoal = goalDao.getById(1);
        assertNull(retrievedGoal);
    }

    /**
     * Tests getting all goals
     */
    @Test
    void getAll() {
        List<Goal> retrievedGoals = goalDao.getAll();

        assertEquals(3, retrievedGoals.size());
    }
}