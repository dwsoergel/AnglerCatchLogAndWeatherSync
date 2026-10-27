package com.dwsoergel.angler.persistence;

import com.dwsoergel.angler.entity.CatchLog;
import com.dwsoergel.angler.entity.TackleItem;
import com.dwsoergel.angler.entity.User;
import com.dwsoergel.angler.testUtils.Database;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenericDaoTest {

    private GenericDao<User> userDao;
    private final Logger logger = LogManager.getLogger(this.getClass());

    /**
     * Sets up DAOs before each test execution.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userDao = new GenericDao<>(User.class);
    }

    /**
     * Verifies that all users can be retrieved from the database successfully.
     */
    @Test
    void getAllUsersSuccess() {
        // Retrieve list of all users from the database
        List<User> users = userDao.getAll();
        logger.debug("Retrieved " + users.size() + " users.");

        // Assert that the result list is not null
        assertNotNull(users);
    }

    /**
     * Verifies that a specific user can be retrieved accurately by their unique ID.
     */
    @Test
    void getByIdSuccess() {
        // Insert a user first so we know an ID exists in the database
        User user = new User("getByIdTest", "getbyid@example.com");
        int id = userDao.insert(user);
        logger.debug("Inserted user for getById with ID: " + id);

        // Fetch the user by ID
        User retrievedUser = userDao.getById(id);

        // Assertions to verify correct data retrieval
        assertNotNull(retrievedUser);
        assertEquals("getByIdTest", retrievedUser.getUsername());
        assertEquals("getbyid@example.com", retrievedUser.getEmail());

        // Clean up after by deleting the test user
        userDao.delete(retrievedUser);
    }

    /**
     * Verifies that user details can be updated and saved back to the database successfully.
     */
    @Test
    void updateUserSuccess() {
        // Insert a test user
        User user = new User("updateTest", "update@example.com");
        int id = userDao.insert(user);

        // Retrieve the user, modify a field (email), and execute update
        User retrieved = userDao.getById(id);
        retrieved.setEmail("newemail@example.com");
        userDao.update(retrieved);

        // Retrieve again and verify the change persisted
        User updated = userDao.getById(id);
        assertEquals("newemail@example.com", updated.getEmail());
    }

    /**
     * Verifies that a user along with associated One-to-Many entities (CatchLogs and TackleItems)
     * can be inserted via cascading and retrieved successfully.
     */
    @Test
    void insertUserWithRelationshipsSuccess() {
        // Create user
        User user = new User("bassmaster99", "bass@example.com");

        // Create child objects and link them using helper methods or direct assignment
        CatchLog catchLog = new CatchLog("Largemouth Bass", 4.5, user);
        TackleItem tackleItem = new TackleItem("Senko Worm", "Soft Plastic", user);

        user.getCatchLogs().add(catchLog);
        user.getTackleItems().add(tackleItem);

        // Insert parent (CascadeType.ALL will insert the child logs/tackle automatically!)
        int insertedId = userDao.insert(user);
        logger.debug("Inserted user ID: " + insertedId);
        assertTrue(insertedId > 0);

        // Retrieve and verify
        User retrievedUser = userDao.getById(insertedId);
        assertNotNull(retrievedUser);
        assertEquals("bassmaster99", retrievedUser.getUsername());

        // Verify One-to-Many relationships loaded correctly
        assertFalse(retrievedUser.getCatchLogs().isEmpty());
        assertEquals("Largemouth Bass", retrievedUser.getCatchLogs().get(0).getSpecies());

        assertFalse(retrievedUser.getTackleItems().isEmpty());
        assertEquals("Senko Worm", retrievedUser.getTackleItems().get(0).getItemName());
    }

    /**
     * Verifies that a user record can be deleted from the database successfully.
     */
    @Test
    void deleteUserSuccess() {
        // Insert a user to ensure something exists to delete
        User user = new User("deleteTest", "delete@example.com");
        int id = userDao.insert(user);

        User retrieved = userDao.getById(id);
        assertNotNull(retrieved);

        // Delete the user record
        userDao.delete(retrieved);
        // Assert that fetching the deleted ID now returns null
        assertNull(userDao.getById(id));
    }
}