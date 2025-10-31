package CapstoneProject25;

import java.io.*;
import java.nio.file.*;
import java.util.regex.*;

public class RegexSearch {

    public static void search(String type, String regex) {
        Path dir = Paths.get("data/logs/" + type);
        if (!Files.exists(dir)) {
            System.out.println("No log folder found for type: " + type);
            return;
        }
        try {
            Pattern pattern = Pattern.compile(regex);
            Files.list(dir).forEach(file -> {
                try (BufferedReader reader = new BufferedReader(new FileReader(file.toFile()))) {
                    String line;
                    while ((line = reader.readLine()) != null) {
                        if (pattern.matcher(line).find()) {
                            System.out.println("Found in " + file.getFileName() + ": " + line);
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Read error: " + e.getMessage());
                }
            });
        } catch (IOException e) {
            System.out.println("Search failed: " + e.getMessage());
        }
    }
}