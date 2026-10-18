import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoginTest {
    private final Login login = new Login();

    @BeforeEach
    void resetMessageLists() {
        Message.sentMessageList.clear();
        Message.storedMessageList.clear();
    }

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

    @Test
    void testMessageIDLength() {
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertTrue(msg.checkMessageID());
    }

    @Test
    void testRecipientCellCorrect() {
        Message msg = new Message(1, "+27718693002", "Hi Mike...");
        assertEquals("Cell phone number successfully added.", msg.checkRecipientCell());
    }

    @Test
    void testRecipientCellIncorrect() {
        Message msg = new Message(1, "08575975889", "Hi Keegan...");
        assertEquals("Cell phone number incorrectly formatted or does not contain international code.", msg.checkRecipientCell());
    }

    @Test
    void testMessageHash() {
        Message msg = new Message(1, "+27718693002", "Hi Mike, can you join us for dinner tonight?");
        assertTrue(msg.getMessageHash().endsWith(":1:HITONIGHT"));
    }

    @Test
    void testSendMessage() {
        Message msg = new Message(1, "+27718693002", "Test");
        assertEquals("Message successfully sent.", msg.SentMessage(1));
    }

    @Test
    void testDisregardMessage() {
        Message msg = new Message(1, "+27718693002", "Test");
        assertEquals("Press 0 to delete the message.", msg.SentMessage(2));
    }

    @Test
    void testStoreMessage() {
        Message msg = new Message(1, "+27718693002", "Test");
        assertEquals("Message successfully stored.", msg.SentMessage(3));
    }
}
