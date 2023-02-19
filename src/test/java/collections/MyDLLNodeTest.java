package collections;

import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.MyDLLNode;

public class MyDLLNodeTest {

    @Test(description = "Checking the method MyDLLNode(E value)", groups = "myDllNobeTests")
    public void testMyDLLNode() {
        MyDLLNode<String> myDllNobe = new MyDLLNode<>("1",
                new MyDLLNode<>("2"),
                new MyDLLNode<>("3"));
        Assert.assertEquals(myDllNobe.getValue(), "1");
        Assert.assertEquals(myDllNobe.getPrev().getValue(), "2");
        Assert.assertEquals(myDllNobe.getNext().getValue(), "3");
    }

    @Test(description = "Checking the method getNext()", groups = "myDllNobeTests")
    public void testGetNext() {
        MyDLLNode<String> myDLLNode = new MyDLLNode<>("1",
                new MyDLLNode<>("2"),
                new MyDLLNode<>("3"));
        Assert.assertEquals(myDLLNode.getNext().getValue(), "3");
    }

    @Test(description = "Checking the method setNext(MyDLLNode<E> next)", groups = "myDllNobeTests")
    public void testSetNext() {
        MyDLLNode<String> myDLLNode = new MyDLLNode<>("1");
        myDLLNode.setNext(new MyDLLNode<>("2"));
        Assert.assertEquals(myDLLNode.getNext().getValue(), "2");
    }

    @Test(description = "Checking the method getPrev()", groups = "myDllNobeTests")
    public void testSetPrev() {
        MyDLLNode<String> myDLLNode = new MyDLLNode<>("1",
                new MyDLLNode<>("2"),
                new MyDLLNode<>("3"));
        Assert.assertEquals(myDLLNode.getPrev().getValue(), "2");
    }

    @Test(description = "Checking the method setPrev(MyDLLNode<E> prev)", groups = "myDllNobeTests")
    public void testGetPrev() {
        MyDLLNode<String> myDLLNode = new MyDLLNode<>("1");
        myDLLNode.setPrev(new MyDLLNode<>("2"));
        Assert.assertEquals(myDLLNode.getPrev().getValue(), "2");
    }


    @Test(description = "Checking the method MyDLLNode(E value)", groups = "myDllNobeTests")
    public void testSetValue() {
        MyDLLNode<String> myDLLNode = new MyDLLNode<>("1");
        myDLLNode.setValue("11");
        Assert.assertEquals(myDLLNode.getValue(), "11");
    }

    @Test(description = "Checking the method getValue()", groups = "myDllNobeTests")
    public void testGetValue() {
        MyDLLNode<String> myDLLNode = new MyDLLNode<>("1");
        Assert.assertEquals(myDLLNode.getValue(), "1");
    }

    @Test(description = "Checking the method equals(MyDLLNode<?> other)",
            groups = "myDllNobeTests")
    public void testEqualsMyDLLNodes() {
        MyDLLNode<String> myDLLNodeFirst = new MyDLLNode<>("1");
        MyDLLNode<String> myDLLNodeSecond = new MyDLLNode<>("2");
        Assert.assertFalse(myDLLNodeFirst.equals(myDLLNodeSecond));
        Assert.assertTrue(myDLLNodeFirst.equals(myDLLNodeFirst));
    }

    @Test(description = "Checking the method valueMatch(E targetValue)",
            groups = "myDllNobeTests")
    public void testValueMatch() {
        MyDLLNode<String> myDLLNodeFirst = new MyDLLNode<>("1");
        Assert.assertTrue(myDLLNodeFirst.valueMatch("1"));
        Assert.assertFalse(myDLLNodeFirst.valueMatch("10"));
    }
}
