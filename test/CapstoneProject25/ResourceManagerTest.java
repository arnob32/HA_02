package CapstoneProject25;  // ✅ Corrected package name

import org.junit.jupiter.api.*;
import java.nio.file.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for ResourceManager class
 */
public class ResourceManagerTest {

    private final String testFile = "data/test_resource.txt";

    @AfterEach
    void cleanUp() throws Exception {
        Files.deleteIfExists(Paths.get(testFile));
    }

    @Test
    void testWriteAndReadNormal() {
        String result = ResourceManager.writeAndReadFile(testFile, "Hello");
        assertEquals("Hello", result);
    }

    @Test
    void testWriteError() {
        String result = ResourceManager.writeAndReadFile("/invalid/path/file.txt", "X");
        assertTrue(result.toLowerCase().contains("write"));
    }

    @Test
    void testFileIsCreated() {
        ResourceManager.writeAndReadFile(testFile, "Check");
        assertTrue(Files.exists(Paths.get(testFile)));
    }

    @Test
    void testEmptyContent() {
        String result = ResourceManager.writeAndReadFile(testFile, "");
        assertEquals("", result);
    }

    @Test
    void testReadError() {
        String result = ResourceManager.writeAndReadFile("data/", "Test");
        assertNotNull(result);
    }
}