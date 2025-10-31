package CapstoneProject25;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ResourceManager {
	public static String writeAndReadFile(String filePath, String content) {
	    try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
	        writer.write(content);
	    } catch (IOException e) {
	        return "Write error: " + e.getMessage();
	    }

	    try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
	        String line = reader.readLine();
	        return (line == null) ? "" : line;   // ✅ Fix: return empty string instead of null
	    } catch (IOException e) {
	        return "Read error: " + e.getMessage();
	    }
	}

}