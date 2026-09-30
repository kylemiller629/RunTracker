package edu.matc.persistence;

import edu.matc.entity.Run;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *Tests the RunDao database
 *
 * @author kmiller
 */
class RunDaoTest {

    RunDao runDao;

    /**
     * Resets the db and creates a RunDao before each test
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        runDao = new RunDao();
    }

    /**
     * Tests the getById method
     */
    @Test
    void getByIdSuccess() {

        Run retrievedRun = runDao.getById(1);

        assertEquals(LocalDate.of(2026, 9, 20), retrievedRun.getRunDate());
        assertEquals(5.0, retrievedRun.getDistance());
        assertEquals(2250, retrievedRun.getDuration());
        assertEquals("Morning run", retrievedRun.getNotes());
    }

    /**
     * Tests updating an existing run
     */
    @Test
    void updateSuccess() {
        Run updatedRun = runDao.getById(1);

        updatedRun.setDistance(6.0);

        runDao.saveOrUpdate(updatedRun);

        Run retrievedRun = runDao.getById(1);

        assertEquals(updatedRun, retrievedRun);
    }

    /**
     * Tests inserting a new run
     */
    @Test
    void insertSuccess() {
        Run newRun = new Run(LocalDate.of(2026, 9, 25), 5.0, 2280, "Evening run");

        int id = runDao.insert(newRun);

        Run retrievedRun = runDao.getById(id);

        assertEquals(newRun, retrievedRun);
    }

    /**
     * Tests deleting an existing run
     */
    @Test
    void deleteSuccess() {

        Run runToDelete = runDao.getById(1);
        runDao.delete(runToDelete);
        Run retrievedRun = runDao.getById(1);
        assertNull(retrievedRun);
    }


    /**
     * Tests retrieving all runs.
     */
    @Test
    void getAll() {
        List<Run> runs = runDao.getAll();
        assertEquals(3, runs.size());
    }
}