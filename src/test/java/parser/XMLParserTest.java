package parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class XMLParserTest {

    @Test
    public void testGetErrors() {
        Assert.assertThrows(FileNotFoundException.class, () -> new XMLParser(""));
    }

    @Test
    public void testTransformLinesToOne() {
        Assert.assertThrows(FileNotFoundException.class, () -> new XMLParser(""));
    }

}
