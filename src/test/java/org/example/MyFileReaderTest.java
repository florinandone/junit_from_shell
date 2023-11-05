package org.example;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class MyFileReaderTest {

      @Test
    public void testFileContainsString() {
        MyFileReader fileReader = new MyFileReader();
        String filePath = "build\\resources\\main\\config\\sample.txt"; // Adjust the path if needed
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
