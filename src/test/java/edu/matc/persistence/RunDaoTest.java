package edu.matc.persistence;

import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    @Test
    void getById() {
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