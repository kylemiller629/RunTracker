package edu.matc.persistence;

import edu.matc.entity.Goal;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
    void getAll() {
    }
}