package edu.matc.persistence;

import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 */
class RunDaoTest {

    RunDao runDao;

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