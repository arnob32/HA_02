package CapstoneProject25;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Airport Luggage System ===");

        // Simulate device message
        TaskSimulator.simulateDataExchange("VEH123", "Vehicle started charging");

        // Create logs
        LogService.writeLog("vehicles", new LogRecord("VEH123", "Charging started"));
        LogService.writeLog("chargers", new LogRecord("CHG01", "Charger ready"));
        LogService.writeLog("system", new LogRecord("SYS", "System OK"));

        // Read today's logs
        System.out.println("\n--- Vehicle Logs ---");
        LogService.readLog("vehicles", LocalDate.now().toString());

        // Search using regex
        System.out.println("\n--- Regex Search for VEH123 ---");
        RegexSearch.search("vehicles", "VEH123");

        // Archive logs
        FileManager.archiveLogs("data/logs", "daily_logs");
    }
}