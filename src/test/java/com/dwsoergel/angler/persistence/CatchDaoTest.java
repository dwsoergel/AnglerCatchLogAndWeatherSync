package com.dwsoergel.angler.persistence;

import com.dwsoergel.angler.entity.CatchLog;
import com.dwsoergel.angler.entity.User;
import com.dwsoergel.angler.testUtils.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CatchDaoTest {

    private GenericDao<CatchLog> catchDao;
    private GenericDao<User> userDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        catchDao = new GenericDao<>(CatchLog.class);
        userDao = new GenericDao<>(User.class);
    }

    @Test
    void getAllCatchesSuccess() {
        List<CatchLog> catches = catchDao.getAll();
        assertNotNull(catches);
    }

    @Test
    void getCatchByIdSuccess() {
        User user = new User("catchUser", "catch@example.com");
        userDao.insert(user);

        CatchLog catchLog = new CatchLog("Smallmouth Bass", 3.2, user);
        int id = catchDao.insert(catchLog);

        CatchLog retrieved = catchDao.getById(id);
        assertNotNull(retrieved);
        assertEquals("Smallmouth Bass", retrieved.getSpecies());
    }

    @Test
    void updateCatchSuccess() {
        User user = new User("updateCatchUser", "uc@example.com");
        userDao.insert(user);

        CatchLog catchLog = new CatchLog("Perch", 1.0, user);
        int id = catchDao.insert(catchLog);

        CatchLog retrieved = catchDao.getById(id);
        retrieved.setSpecies("Yellow Perch");
        catchDao.update(retrieved);

        CatchLog updated = catchDao.getById(id);
        assertEquals("Yellow Perch", updated.getSpecies());
    }

    @Test
    void deleteCatchSuccess() {
        User user = new User("deleteCatchUser", "dc@example.com");
        userDao.insert(user);

        CatchLog catchLog = new CatchLog("Bluegill", 0.8, user);
        int id = catchDao.insert(catchLog);

        CatchLog retrieved = catchDao.getById(id);
        catchDao.delete(retrieved);
        assertNull(catchDao.getById(id));
    }
}