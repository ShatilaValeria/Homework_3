package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.MyStack;
import utilities.StackADT;

import java.util.EmptyStackException;

public class MyStackTest {

    private MyStack<Integer> testingStack;

    @BeforeMethod
    public void initStack() {
        testingStack = new MyStack<>();
    }

    @Test(groups = "additionTests")
    public void testInitialSize() {
        Assert.assertEquals(testingStack.size(), 0);
    }

    @Test(description = "Checking the method push(E toAdd)", groups = "additionTests")
    public void testPush() {
        testingStack.push(6);
        Assert.assertEquals(testingStack.size(), 1);
    }

    @Test(description = "Checking the method push(E toAdd) for the Exception", groups = "additionTests")
    public void testPushException() {
        Assert.assertThrows(NullPointerException.class, () -> testingStack.push(null));
    }

    @Test(description = "Checking the method pop()", groups = "additionTests")
    public void testPop() {
        StackADT<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        Assert.assertEquals(stack.pop(), "Three");
    }

    @Test(description = "Checking the method pop() for the Exception", groups = "additionTests")
    public void testPopException() {
        Assert.assertThrows( EmptyStackException.class, () -> testingStack.pop());
    }

    @Test(description = "Checking the method ", groups = "additionTests")
    public void testPeek() {
        StackADT<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        Assert.assertEquals(stack.peek(), "Three");
    }

    @Test(description = "Checking the method peek() for the Exception", groups = "additionTests")
    public void testPeekException() {
        Assert.assertThrows( EmptyStackException.class, () -> testingStack.peek());
    }

    @Test(description = "Checking the method clear", groups = "additionTests")
    public void testClear() {
        StackADT<String> stack = new MyStack<>();
        stack.push("One");
        stack.push("Two");
        stack.push("Three");
        stack.clear();
        Assert.assertTrue(stack.isEmpty());
    }

    @Test(description = "Checking the method isEmpty()", groups = "additionTests")
    public void testIsEmpty() {
        Assert.assertTrue(testingStack.isEmpty());
    }

    @Test(description = "Checking the method toArray(E[] holder)", groups = "additionTests")
    public void testToArraySecond() {
        Integer[] checkArray = {1, 2, 3};
        Integer[] expected = {1, 2, 3};
        Assert.assertEquals(testingStack.toArray(checkArray), expected);
    }

    @Test(description = "Checking the method toArray(E[] holder) for Exception", groups = "additionTests")
    public void testToArraySecondException() {
        Assert.assertThrows(NullPointerException.class, () -> testingStack.toArray(null));
    }

    @Test(description = "Checking the method contains(E toFind))", groups = "additionTests")
    public void testContains() {
        testingStack.push(1);
        testingStack.push(2);
        testingStack.push(3);
        Assert.assertTrue(testingStack.contains(1));
        Assert.assertTrue(testingStack.contains(2));
        Assert.assertTrue(testingStack.contains(3));
        Assert.assertFalse(testingStack.contains(10));
    }

    @Test(description = "Checking the method contains(E toFind)) for Exception", groups = "additionTests")
    public void testContainsException() {
        Assert.assertThrows(NullPointerException.class, () -> testingStack.contains(null));
    }

    @Test(description = "Checking the method search(E toFind))", groups = "additionTests")
    public void testSearch() {
        testingStack.push(1);
        testingStack.push(2);
        testingStack.push(3);
        Assert.assertEquals(testingStack.search(null), -1);
        Assert.assertEquals(testingStack.search(1), 3);
        Assert.assertEquals(testingStack.search(2), 2);
        Assert.assertEquals(testingStack.search(3), 1);
    }

    @Test(description = "Checking the method equals(StackADT<E> that))", groups = "additionTests")
    public void testEquals() {
        StackADT<Integer> stack1 = new MyStack<>();
        StackADT<Integer> stack2 = new MyStack<>();
        stack1.push(1);
        stack1.push(2);
        stack2.push(1);
        stack2.push(2);
        Assert.assertTrue(stack1.equals(stack2));
    }
}
