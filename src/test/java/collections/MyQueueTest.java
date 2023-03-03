package collections;

import exceptions.EmptyQueueException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.MyQueue;
import utilities.QueueADT;

public class MyQueueTest {

    private MyQueue<String> myQueue;

    @BeforeMethod
    public void initArray() {
        myQueue = new MyQueue<>();
    }

    @Test(description = "Checking the method enqueue(E toAdd) for the NullPointerException",
            groups = "MyQueueTest")
    public void testEnqueueNullPointerException() {
        Assert.assertThrows(NullPointerException.class, () -> myQueue.enqueue(null));
    }

    @Test(description = "Checking the method enqueue(E toAdd) for the RuntimeException",
            groups = "MyQueueTest")
    public void testEnqueueRuntimeException() {
       Assert.assertThrows(RuntimeException.class, () -> myQueue.isFull());
    }

    @Test(description = "Checking the method enqueue(E toAdd) ", groups = "MyQueueTest")
    public void testEnqueue() {
        Assert.assertEquals(myQueue.size(), 0);
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");
        Assert.assertEquals(myQueue.size(), 3);
    }

    @Test(description = "Checking the method dequeue() for the Exception", groups = "MyQueueTest")
    public void testDequeueException() {
        Assert.assertThrows(EmptyQueueException.class, () -> myQueue.dequeue());
    }

    @Test(description = "Checking the method dequeue()", groups = "MyQueueTest")
    public void testDequeue() {
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");
        Assert.assertEquals(myQueue.dequeue(), "a");
        Assert.assertEquals(myQueue.size(), 2);
    }

    @Test(description = "Checking the method peek() for the Exception", groups = "MyQueueTest")
    public void testPeekException() {
        Assert.assertThrows(EmptyQueueException.class, () -> myQueue.peek());
    }

    @Test(description = "Checking the method peek()", groups = "MyQueueTest")
    public void testPeek() {
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");
        Assert.assertEquals(myQueue.peek(), "a");
    }

    @Test(description = "Checking the method dequeueAll()", groups = "MyQueueTest")
    public void testDequeueAll() {
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");
        myQueue.dequeueAll();
        Assert.assertEquals(myQueue.size(), 0);
    }

    @Test(description = "Checking the method isEmpty()", groups = "MyQueueTest")
    public void testIsEmpty() {
        Assert.assertTrue(myQueue.isEmpty());
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");
        Assert.assertFalse(myQueue.isEmpty());
    }

    @Test(description = "Checking the method equals(QueueADT<E> that) for the True", groups = "MyQueueTest")
    public void testEqualsTrue() {
        QueueADT<String> myQueueFirst = new MyQueue<>();
        myQueueFirst.enqueue("a");
        myQueueFirst.enqueue("b");
        myQueueFirst.enqueue("c");

        QueueADT<String> myQueueSecond = new MyQueue<>();
        myQueueSecond.enqueue("a");
        myQueueSecond.enqueue("b");
        myQueueSecond.enqueue("c");

        Assert.assertTrue(myQueueFirst.equals(myQueueSecond));
    }

    @Test(description = "Checking the method equals(QueueADT<E> that) for the False", groups = "MyQueueTest")
    public void testEqualsFalse() {
        QueueADT<String> myQueueFirst = new MyQueue<>();
        myQueueFirst.enqueue("a");
        myQueueFirst.enqueue("b");
        myQueueFirst.enqueue("c");

        QueueADT<String> myQueueSecond = new MyQueue<>();
        myQueueSecond.enqueue("1");
        myQueueSecond.enqueue("2");
        myQueueSecond.enqueue("3");

        Assert.assertFalse(myQueueFirst.equals(myQueueSecond));
    }

    @Test(description = "Checking the method equals(QueueADT<E> that) for the False", groups = "MyQueueTest")
    public void testEqualsFalseSecond() {
        QueueADT<String> myQueueFirst = new MyQueue<>();
        myQueueFirst.enqueue("a");
        myQueueFirst.enqueue("b");
        myQueueFirst.enqueue("c");

        QueueADT<String> myQueueSecond = new MyQueue<>();
        myQueueSecond.enqueue("a");
        myQueueSecond.enqueue("b");

        Assert.assertFalse(myQueueFirst.equals(myQueueSecond));
    }

    @Test(description = "Checking the method Object[] toArray()", groups = "MyQueueTest")
    public void testToArray() {
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");

        String[] expected = {"a", "b", "c"};
        Assert.assertEquals(myQueue.toArray(), expected);
    }

    @Test(description = "Checking the method toArray(E[] holder) for the Exception", groups = "MyQueueTest")
    public void testToArrayException() {
        Assert.assertThrows(NullPointerException.class, () -> myQueue.toArray(null));
    }

    @Test(description = "Checking the method isFull()", groups = "MyQueueTest")
    public void testIsFull() {
        Assert.assertFalse(myQueue.isFull());
    }

    @Test(description = "Checking the method size()", groups = "MyQueueTest")
    public void testSize() {
        myQueue.enqueue("a");
        myQueue.enqueue("b");
        myQueue.enqueue("c");

        Assert.assertEquals(myQueue.size(), 3);
    }
}
