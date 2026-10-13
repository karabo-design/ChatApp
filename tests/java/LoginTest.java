import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LoginTest {
    private final Login login = new Login();

    @Test
    void checkUserNameReturnsTrueForValidUsername() {
        assertTrue(login.checkUserName("abc_1"));
    }

    @Test
    void checkUserNameReturnsFalseForInvalidUsername() {
        assertFalse(login.checkUserName("abcde"));
        assertFalse(login.checkUserName("abcdef"));
    }

    @Test
    void checkPasswordComplexityReturnsTrueForValidPassword() {
        assertTrue(login.checkPasswordComplexity("Password1!"));
    }

    @Test
    void checkPasswordComplexityReturnsFalseForInvalidPassword() {
        assertFalse(login.checkPasswordComplexity("password"));
        assertFalse(login.checkPasswordComplexity("Password"));
    }

    @Test
    void checkCellPhoneNumberReturnsTrueForSouthAfricanNumber() {
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    void registerUserStoresDetailsAndReturnsSuccessMessage() {
        String message = login.registerUser("u_1", "Password1!", "+27838968976", "Jane", "Doe");

        assertTrue(message.contains("User registered successfully."));
        assertTrue(login.loginUser("u_1", "Password1!"));
    }

    @Test
    void returnLoginStatusReturnsWelcomeMessageForSuccessfulLogin() {
        login.registerUser("j_1", "Password1!", "+27838968976", "Jane", "Doe");

        assertEquals("Welcome Jane, Doe it is great to see you again.", login.returnLoginStatus(true));
    }

    @Test
    void returnLoginStatusReturnsErrorMessageForFailedLogin() {
        login.registerUser("h_1", "Password1!", "+27838968976", "John", "Smith");

        assertEquals("Username or password incorrect, please try again.", login.returnLoginStatus(false));
    }
}
