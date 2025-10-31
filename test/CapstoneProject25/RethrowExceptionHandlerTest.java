package CapstoneProject25;  // ✅ matches test/CapstoneProject25 folder

import org.junit.jupiter.api.*;

import exceptionshandling.CustomException;
import exceptionshandling.RethrowExceptionHandler;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for RethrowExceptionHandler class
 */
public class RethrowExceptionHandlerTest {

    @Test
    void testRethrowTriggered() {
        assertThrows(CustomException.class, () -> RethrowExceptionHandler.riskyOperation(true));
    }

    @Test
    void testNoException() {
        assertDoesNotThrow(() -> RethrowExceptionHandler.riskyOperation(false));
    }

    @Test
    void testMessageContainsRethrown() {
        CustomException e = assertThrows(CustomException.class,
                () -> RethrowExceptionHandler.riskyOperation(true));
        assertTrue(e.getMessage().toLowerCase().contains("re-thrown"));
    }

    @Test
    void testCauseExists() {
        CustomException e = assertThrows(CustomException.class,
                () -> RethrowExceptionHandler.riskyOperation(true));
        assertNotNull(e.getCause());
    }

    @Test
    void testCauseType() {
        CustomException e = assertThrows(CustomException.class,
                () -> RethrowExceptionHandler.riskyOperation(true));
        assertTrue(e.getCause() instanceof IllegalArgumentException);
    }
}
