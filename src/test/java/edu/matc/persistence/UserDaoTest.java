package edu.matc.persistence;

import edu.matc.test.util.Database;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {

    UserDao userDao;

    /**
     *
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleanDB.sql");
        userDao = new UserDao();
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