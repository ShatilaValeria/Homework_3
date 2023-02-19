package parser;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

public class XMLParserTest {

    @Test( description = "Checking the method getName() for the Exception",
            groups = "xmlParserTest")
    public void testGetName() {
        Assert.assertThrows(FileNotFoundException.class, () -> new XMLParser(""));
    }

    //Не видит валидного файла!!!
    @Test( description = "Checking the method XMLParser(String filename)",
            groups = "xmlParserTest")
    public void testXMLParserTrue() {
        XMLParser xmlParser = new XMLParser("src/test/java/xmlFile/XmlFirstFile");
        xmlParser.parseDocument();
        Assert.assertTrue(xmlParser.getErrors().isEmpty());
    }

    @Test( description = "Checking the method XMLParser(String filename)",
            groups = "xmlParserTest")
    public void testXMLParserTrueSecond() {
        XMLParser xmlParser = new XMLParser("src/test/java/xmlFile/Check");
        xmlParser.parseDocument();
        Assert.assertTrue(xmlParser.getErrors().isEmpty());
    }

    @Test( description = "Checking the method XMLParser(String filename)",
            groups = "xmlParserTest")
    public void testXMLParserFalse() {
        XMLParser xmlParser = new XMLParser("src/test/java/xmlFile/XmlSecondFileError");
        xmlParser.parseDocument();
        Assert.assertFalse(xmlParser.getErrors().isEmpty());
    }

    @Test( description = "Checking the method XMLParser(String filename)",
            groups = "xmlParserTest")
    public void testXMLParserSecondFalse() {
        XMLParser xmlParser = new XMLParser("src/test/java/xmlFile/XmlThirdFileError");
        xmlParser.parseDocument();
        Assert.assertFalse(xmlParser.getErrors().isEmpty());
    }
}
