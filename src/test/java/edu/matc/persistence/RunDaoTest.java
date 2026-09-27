package edu.matc.persistence;

import edu.matc.entity.Run;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class RunDaoTest {

    RunDao runDao;

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        runDao = new RunDao();
    }

    /**
     * Verifies id generate is succesfull
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
    void updateSuccess() {
        Run updatedRun = runDao.getById(1);

        updatedRun.setDistance(6.0);

        runDao.saveOrUpdate(updatedRun);

        Run retrievedRun = runDao.getById(1);

        assertEquals(6, retrievedRun.getDistance());
    }

    @Test
    void insertSuccess() {
        Run newRun = new Run(LocalDate.of(2026, 9, 25), 5.0, 2280, "Evening run");

        int id = runDao.insert(newRun);

        Run retrievedRun = runDao.getById(id);

        assertEquals(LocalDate.of(2026, 9, 25), retrievedRun.getRunDate());
        assertEquals(5.0, retrievedRun.getDistance());
        assertEquals(2280, retrievedRun.getDuration());
        assertEquals("Evening run", retrievedRun.getNotes());

    }

    @Test
    void deleteSuccess() {

        Run runToDelete = runDao.getById(1);
        runDao.delete(runToDelete);
        Run retrievedRun = runDao.getById(1);
        assertNull(retrievedRun);
    }

    @Test
    void getAll() {
        List<Run> runs = runDao.getAll();
        assertEquals(3, runs.size());
    }
}