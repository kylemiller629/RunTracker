package edu.matc.persistence;

import edu.matc.entity.Run;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for RunDao
 * @author kmiller
 */
class RunDaoTest {

    RunDao runDao;

    /**
     * Sets up the run table with fresh data
     */
    @BeforeEach
    void setUp() {
        Database database = new Database();
        database.runSQL("cleanDB.sql");
        runDao = new RunDao();
    }

    /**
     * Verifies getById successfully retrieves a run
     */
    @Test
    void getByIdSuccess() {
        Run retrievedRun = runDao.getById(1);

        assertEquals(LocalDate.of(2026, 9, 20), retrievedRun.getRunDate());
        assertEquals(5.0, retrievedRun.getDistance());
        assertEquals(2250, retrievedRun.getDuration());
        assertEquals("Morning run", retrievedRun.getNotes());
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