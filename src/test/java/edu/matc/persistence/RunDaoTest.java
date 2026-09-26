package edu.matc.persistence;

import edu.matc.entity.Run;
import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
    void getById() {

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