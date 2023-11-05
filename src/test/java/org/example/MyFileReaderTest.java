package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import java.io.IOException;
import java.net.URISyntaxException;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class MyFileReaderTest {

    @BeforeAll
    public static void beforeAll() throws IOException, URISyntaxException{
        ResourceCopier.copyResourcesIfNotExists();
    }
    @Test
    public void testFileContainsString() {
        MyFileReader fileReader = new MyFileReader();
        String filePath = "config/sample.txt"; // Adjust the path if needed
        String targetString = "This is a sample file with abc in it.";
        boolean result = fileReader.doesFileContainString(filePath, targetString);
        assertTrue(result);
    }
    @Test
    @Disabled
    public void sampleFail() {
        fail("sample");
    }
}
