package CapstoneProject25;

import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;

public class LogService {

    public static void writeLog(String type, LogRecord record) {
        try {
            String date = LocalDate.now().toString();
            Path path = Paths.get("data/logs/" + type + "/log_" + date + ".txt");
            Files.createDirectories(path.getParent());

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path.toFile(), true))) {
                writer.write(record.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing log: " + e.getMessage());
        }
    }

    public static void readLog(String type, String date) {
        Path path = Paths.get("data/logs/" + type + "/log_" + date + ".txt");
        if (!Files.exists(path)) {
            System.out.println("No log found for " + date);
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading log: " + e.getMessage());
        }
    }
}