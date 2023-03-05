package parser;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ListADT;
import utilities.MyArrayList;

public class XMLTagTest {

    @Test(description = "Checking the method getErrors", groups = "xmlTagTest")
    public void tesGetName() {
        XMLTag xmlTag = new XMLTag("Checking");
        Assert.assertEquals(xmlTag.getName(), "Checking");
    }

    @Test(description = "Checking the method setName(String name)", groups = "xmlTagTest")
    public void tesSetName() {
        XMLTag xmlTag = new XMLTag("Checking");
        xmlTag.setName("Checking name 2");
        Assert.assertEquals(xmlTag.getName(), "Checking name 2");
    }

    @Test(description = "Checking the method getProperties()", groups = "xmlTagTest")
    public void testGetProperties() {
        XMLTag xmlTag = new XMLTag("Checking");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(xmlTag.getProperties(), new MyArrayList<>());
    }

    @Test(description = "Checking the method setProperties(ListADT<TagProperty> properties) ", groups = "xmlTagTest")
    public void testSetPropertiesALLClass() {
        XMLTag.TagProperty tagProperty = new XMLTag.TagProperty("Checking", "1");
        Assert.assertEquals(tagProperty.getName(), "Checking");
        Assert.assertEquals(tagProperty.getValue(), "1");

        tagProperty.setName("Checking 2");
        Assert.assertEquals(tagProperty.getName(), "Checking 2");
        tagProperty.setValue("2");
        Assert.assertEquals(tagProperty.getValue(), "2");
    }

    @Test(description = "Checking the method getNestedTags()", groups = "xmlTagTest")
    public void testGetNestedTags() {
        XMLTag xmlTag = new XMLTag("Checking");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(xmlTag.getNestedTags(), new MyArrayList<>());
    }

    @Test(description = "Checking the method setNestedTags(ListADT<XMLTag> nestedTags)",
            groups = "xmlTagTest")
    public void tesSetNestedTags() {
        XMLTag xmlTag = new XMLTag("Checking");
        ListADT<XMLTag> list = new MyArrayList<>();
        list.add(new XMLTag("1"));
        list.add(new XMLTag("2"));
        xmlTag.setNestedTags(list);
        Assert.assertEquals(xmlTag.getNestedTags(), list);
    }

    @Test(description = "Checking the method getText()", groups = "xmlTagTest")
    public void testGetText() {
        XMLTag xmlTag = new XMLTag("Checking");
        Assert.assertEquals(xmlTag.getText(), null);
    }

    @Test(description = "Checking the method setText(String text)", groups = "xmlTagTest")
    public void testSetText() {
        XMLTag xmlTag = new XMLTag("Checking");
        xmlTag.setText("1");
        Assert.assertEquals(xmlTag.getText(), "1");
    }
}
