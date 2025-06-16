package delivery;

import delivery.classes.*;
import delivery.interfaces.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {

    private UserService userService;

    @BeforeEach
    void setUp() {
        userService = new UserServiceImpl();
    }

    @Test
    void testRegisterUserSuccessfully() {
        User user = userService.register("testuser", "password");
        assertNotNull(user);
        assertEquals("testuser", user.getUsername());
        assertEquals(Role.USER, user.getRole());
    }

    @Test
    void testAuthenticateSuccess() {
        userService.register("john", "secret");
        assertTrue(userService.authenticate("john", "secret"));
    }

    @Test
    void testAuthenticateFailWithWrongPassword() {
        userService.register("john", "secret");
        assertFalse(userService.authenticate("john", "wrongpass"));
    }

    @Test
    void testAuthenticateFailWithUnknownUser() {
        assertFalse(userService.authenticate("ghost", "any"));
    }
}
