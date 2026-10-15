package edu.matc.persistence;

import edu.matc.entity.Run;
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
}
