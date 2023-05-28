package com.uade.screenspace.repository;

import com.uade.screenspace.entity.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@DataMongoTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    private static String EMAIL = "test@email";
    private static String PASS = "password";
    private static boolean IS_OWNER = true;

    @AfterEach
    public void cleanup(){
        repository.deleteAll();
    }

    @Test
    void createAndFindByEmailAndPasswordAndIsOwner() {
        var user = createTestUser(EMAIL, PASS, IS_OWNER);
        repository.save(user);
        var foundUser = repository.findByEmailAndPasswordAndIsOwner(EMAIL, PASS, IS_OWNER);
        assertNotNull(foundUser);
        assertTrue(user.getEmail().equals(foundUser.getEmail()) && user.getPassword().equals(foundUser.getPassword()) && user.getOwner() == foundUser.getOwner() && foundUser.getId() != null);
    }

    @Test
    void findByEmailAndIsOwner() {
        var user = createTestUser(EMAIL, PASS, IS_OWNER);
        repository.save(user);
        var foundUser = repository.findByEmailAndIsOwner(EMAIL, IS_OWNER);
        assertNotNull(foundUser);
        assertTrue(user.getEmail().equals(foundUser.getEmail()) && user.getPassword().equals(foundUser.getPassword()) && user.getOwner() == foundUser.getOwner() && foundUser.getId() != null);
    }

    @Test
    void deleteByEmailAndIsOwner() {
        var user = createTestUser(EMAIL, PASS, IS_OWNER);
        repository.save(user);
        var deleted = repository.deleteByEmailAndIsOwner(EMAIL, IS_OWNER);
        var found = repository.findByEmailAndIsOwner(EMAIL, IS_OWNER);

        assertEquals(1, deleted);
        assertNull(found);
    }

    private User createTestUser(String email, String password, boolean isOwner){
        return new User(email, password, isOwner, null);
    }
}