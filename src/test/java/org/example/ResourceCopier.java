package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.Objects;

public class ResourceCopier {

    public static void main(String[] args) throws IOException, URISyntaxException{
        copyResourcesIfNotExists();
    }

    public static void copyResourcesIfNotExists() throws IOException, URISyntaxException{
        String sourceDirectory = "resources/config";
        String destinationDirectory = "config";

        if (!destinationDirectoryExists(destinationDirectory)) {
            copyResources(sourceDirectory, destinationDirectory);
        }
    }

    public static boolean destinationDirectoryExists(String destinationDir) throws IOException, URISyntaxException{
        File destination = new File(destinationDir);
        return destination.exists() && destination.isDirectory();
    }

    public static void copyResources(String sourceDir, String destinationDir)throws IOException, URISyntaxException{
       
            File source = new File(Objects.requireNonNull(ResourceCopier.class.getClassLoader().getResource(sourceDir)).toURI());
            File destination = new File(destinationDir);

            if (source.isDirectory()) {
                if (!destination.exists()) {
                    destination.mkdirs();
                }
                File[] files = source.listFiles();
                if (files != null) {
                    for (File file : files) {
                        if (file.isFile()) {
                            copyFile(file, new File(destination, file.getName()));
                        }
                    }
                }
            }
       
    }

    public static void copyFile(File sourceFile, File destFile) throws IOException {
        try (InputStream in = ResourceCopier.class.getClassLoader().getResourceAsStream(sourceFile.getPath());
             OutputStream out = new FileOutputStream(destFile)) {

            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }
}
