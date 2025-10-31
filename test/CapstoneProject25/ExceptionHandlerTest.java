package CapstoneProject25;  // ✅ matches test/CapstoneProject25 folder

import org.junit.jupiter.api.Test;

import exceptionshandling.CustomException;
import exceptionshandling.ExceptionHandler;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for ChainedExceptionHandler class
 */
public class ExceptionHandlerTest {

    @Test
    void testThrowsCustomException() {
        assertThrows(CustomException.class, ExceptionHandler::simulateChainedError);
    }

    @Test
    void testCauseNotNull() {
        try {
            ExceptionHandler.simulateChainedError();
        } catch (CustomException e) {
            assertNotNull(e.getCause());
        }
    }

    @Test
    void testCauseType() {
        try {
            ExceptionHandler.simulateChainedError();
        } catch (CustomException e) {
            assertTrue(e.getCause() instanceof NullPointerException);
        }
    }

    @Test
    void testOuterMessage() {
        CustomException e = assertThrows(CustomException.class, ExceptionHandler::simulateChainedError);
        assertTrue(e.getMessage().toLowerCase().contains("outer"));
    }

    @Test
    void testInnerMessage() {
        try {
            ExceptionHandler.simulateChainedError();
        } catch (CustomException e) {
            assertEquals("Inner problem", e.getCause().getMessage());
        }
    }
}
