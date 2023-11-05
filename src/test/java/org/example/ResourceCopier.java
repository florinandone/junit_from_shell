package org.example;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class ResourceCopier {

    public static void main(String[] args) throws IOException, URISyntaxException{
        copyResourcesIfNotExists();
    }

    public static void copyResourcesIfNotExists() throws IOException, URISyntaxException{
        String sourceDirectory = "config";
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
       
            URL resourceURL = Objects.requireNonNull(ResourceCopier.class.getClassLoader().getResource(sourceDir));
            File source = new File(resourceURL.toURI());
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
        Files.copy(Paths.get(sourceFile.getPath()), Paths.get(destFile.getPath()));
    }
}
