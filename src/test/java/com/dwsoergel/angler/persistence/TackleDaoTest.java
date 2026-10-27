package com.dwsoergel.angler.persistence;

import com.dwsoergel.angler.entity.TackleItem;
import com.dwsoergel.angler.entity.User;
import com.dwsoergel.angler.testUtils.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TackleDaoTest {

    private GenericDao<TackleItem> tackleDao;
    private GenericDao<User> userDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        tackleDao = new GenericDao<>(TackleItem.class);
        userDao = new GenericDao<>(User.class);
    }

    @Test
    void getAllTackleSuccess() {
        List<TackleItem> tackleItems = tackleDao.getAll();
        assertNotNull(tackleItems);
    }

    @Test
    void getTackleByIdSuccess() {
        User user = new User("tackleUser", "tackle@example.com");
        userDao.insert(user);

        TackleItem tackleItem = new TackleItem("Spinnerbait", "Hard Bait", user);
        int id = tackleDao.insert(tackleItem);

        TackleItem retrieved = tackleDao.getById(id);
        assertNotNull(retrieved);
        assertEquals("Spinnerbait", retrieved.getItemName());
    }

    @Test
    void updateTackleSuccess() {
        User user = new User("updateTackleUser", "ut@example.com");
        userDao.insert(user);

        TackleItem tackleItem = new TackleItem("Jig", "Metal", user);
        int id = tackleDao.insert(tackleItem);

        TackleItem retrieved = tackleDao.getById(id);
        retrieved.setItemName("Football Jig");
        tackleDao.update(retrieved);

        TackleItem updated = tackleDao.getById(id);
        assertEquals("Football Jig", updated.getItemName());
    }

    @Test
    void deleteTackleSuccess() {
        User user = new User("deleteTackleUser", "dt@example.com");
        userDao.insert(user);

        TackleItem tackleItem = new TackleItem("Frog", "Topwater", user);
        int id = tackleDao.insert(tackleItem);

        TackleItem retrieved = tackleDao.getById(id);
        tackleDao.delete(retrieved);
        assertNull(tackleDao.getById(id));
    }
}