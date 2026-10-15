package edu.matc.persistence;

import edu.matc.entity.Run;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
}
