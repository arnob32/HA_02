package CapstoneProject25;

import java.io.*;

public class MultipleExceptionHandlerTest {

    public static String processInput(String fileName, String number) {
        try {
            // ✅ Step 1: Check for null or invalid file name before using it
            if (fileName == null || fileName.isEmpty()) {
                return "Error: file name is null or empty";
            }

            // Step 2: Try opening the file
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            reader.close();

            // Step 3: Try parsing number
            int value = Integer.parseInt(number);

            // Step 4: Everything worked
            return "Processed successfully: " + line + " | Number: " + value;

        } catch (FileNotFoundException e) {
            return "FileNotFoundException: " + e.getMessage();
        } catch (NumberFormatException e) {
            return "NumberFormatException: " + e.getMessage();
        } catch (IOException e) {
            return "IOException: " + e.getMessage();
        } catch (Exception e) {
            return "Unexpected error: " + e.getMessage();
        }
    }
}

