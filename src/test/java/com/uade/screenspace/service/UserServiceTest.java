package com.uade.screenspace.service;

import com.uade.screenspace.entity.Code;
import com.uade.screenspace.entity.PendingUser;
import com.uade.screenspace.entity.User;
import com.uade.screenspace.repository.PendingUserRepository;
import com.uade.screenspace.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

//@AutoConfigureDataMongo
@SpringBootTest
@ContextConfiguration(classes = {UserService.class})
class UserServiceTest {

    @Autowired
    IUserService service;

    @MockBean
    UserRepository repository;
    @MockBean
    PendingUserRepository pendingUserRepository;
    @MockBean
    IEmailSender sender;

    private static String EMAIL = "test@email";
    private static String PASS = "password";
    private static boolean IS_OWNER = true;

    @Test
    void createUser() {
        var expectedUser = createTestPendingUser(EMAIL, PASS, IS_OWNER);
        Mockito.when(pendingUserRepository.save(Mockito.any(PendingUser.class))).thenReturn(expectedUser);

        var returnedUser = service.createPendingUser(EMAIL, PASS, IS_OWNER);

        assertEquals(expectedUser, returnedUser);
    }

    @Test
    void findUser() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }

    @Test
    void passwordReset() {
    }

    @Test
    void confirmPasswordReset() {
    }

    private PendingUser createTestPendingUser(String email, String password, boolean isOwner){
        return new PendingUser(new User(email, password, isOwner, null), new Code("aaa", Instant.now()));
    }
}