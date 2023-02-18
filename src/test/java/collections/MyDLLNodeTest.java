package collections;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.MyDLLNode;

public class MyDLLNodeTest {

    @Test
    public void testConstructorWithAllParameters() {
        MyDLLNode<String> myDllNobe = new MyDLLNode<>("1",
                new MyDLLNode<>("2"),
                new MyDLLNode<>("3"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(myDllNobe.getValue(), "1");
        softAssert.assertEquals(myDllNobe.getPrev().getValue(), "2");
        softAssert.assertEquals(myDllNobe.getNext().getValue(), "3");

        softAssert.assertAll();
    }

    @Test
    public void testSetPrev() {
        MyDLLNode<String> myDLLNode = new MyDLLNode<>("1");
        myDLLNode.setPrev(new MyDLLNode<>("2"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(myDLLNode.getValue(), "1");
        softAssert.assertEquals(myDLLNode.getPrev().getValue(), "2");
        softAssert.assertEquals(myDLLNode.getNext(), null);

        softAssert.assertAll();
    }

    @Test
    public void testSetNext() {
        MyDLLNode<String> node = new MyDLLNode<>("1");
        node.setNext(new MyDLLNode<>("2"));

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(node.getValue(), "1");
        softAssert.assertEquals(node.getPrev(), null);
        softAssert.assertEquals(node.getNext().getValue(), "2");

        softAssert.assertAll();
    }

    @Test
    public void testSetValue() {
        MyDLLNode<String> node = new MyDLLNode<>("1");
        node.setValue("11");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(node.getValue(), "11");
        softAssert.assertEquals(node.getPrev(), null);
        softAssert.assertEquals(node.getNext(), null);

        softAssert.assertAll();
    }

    @Test
    public void testEqualsMyDLLNodes() {
        MyDLLNode<String> myDLLNodeFirst = new MyDLLNode<>("1");
        MyDLLNode<String> myDLLNodeSecond = new MyDLLNode<>("2");

        Assert.assertTrue(myDLLNodeFirst.equals(myDLLNodeSecond));
    }

    @Test
    public void testEqualsDifferentMyDLLNodesByPrevAndNextFields() {
        MyDLLNode<String> myDLLNodeFirst = new MyDLLNode<>("1",
                new MyDLLNode<>("2"),
                new MyDLLNode<>("3"));
        MyDLLNode<String> myDLLNodeSecond = new MyDLLNode<>("1");

        Assert.assertFalse(myDLLNodeFirst.equals(myDLLNodeSecond));
    }

}
