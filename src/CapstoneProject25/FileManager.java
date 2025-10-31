package CapstoneProject25;

import java.io.*;
import java.nio.file.*;
import java.util.zip.*;

public class FileManager {

    public static void archiveLogs(String sourceFolder, String zipName) {
        Path sourcePath = Paths.get(sourceFolder);
        Path zipPath = Paths.get("data/archive/" + zipName + ".zip");

        try {
            Files.createDirectories(zipPath.getParent());
            try (ZipOutputStream zos = new ZipOutputStream(Files.newOutputStream(zipPath))) {
                Files.walk(sourcePath)
                     .filter(Files::isRegularFile)
                     .forEach(file -> {
                         try (InputStream in = Files.newInputStream(file)) {
                             ZipEntry entry = new ZipEntry(sourcePath.relativize(file).toString());
                             zos.putNextEntry(entry);
                             in.transferTo(zos);
                             zos.closeEntry();
                         } catch (IOException e) {
                             System.out.println("Error zipping: " + e.getMessage());
                         }
                     });
            }
            System.out.println("Logs archived: " + zipPath);
        } catch (IOException e) {
            System.out.println("Archiving failed: " + e.getMessage());
        }
    }

    public static void moveLog(String from, String to) {
        try {
            Files.move(Paths.get(from), Paths.get(to), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Moved log to: " + to);
        } catch (IOException e) {
            System.out.println("Move failed: " + e.getMessage());
        }
    }

    public static void deleteLog(String path) {
        try {
            Files.deleteIfExists(Paths.get(path));
            System.out.println("Deleted: " + path);
        } catch (IOException e) {
            System.out.println("Delete failed: " + e.getMessage());
        }
    }
}