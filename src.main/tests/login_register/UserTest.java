package login_register;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void checkUsername() {
        User user = new User("Andrei", "parolamea", "rolulmeu");
        assertTrue(user.checkUsername(user.getName()));
        assertFalse(user.checkUsername("Ioana"));

    }

    @Test
    void checkPassword() {
        User user = new User("Andrei", "parolamea", "rolulmeu");
        assertTrue(user.checkPassword(user.getPassword()));
        assertFalse(user.checkPassword("as12"));
    }
}