package CapstoneProject25;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TaskSimulator {

    public static void simulateDataExchange(String equipmentId, String message) {
        String data = "Device: " + equipmentId + " | Message: " + message;
        try (ByteArrayInputStream input = new ByteArrayInputStream(data.getBytes())) {
            int byteData;
            System.out.print("Simulated bytes: ");
            while ((byteData = input.read()) != -1) {
                System.out.print((char) byteData);
            }
            System.out.println();
        } catch (IOException e) {
            System.out.println("Simulation failed: " + e.getMessage());
        }
    }
}