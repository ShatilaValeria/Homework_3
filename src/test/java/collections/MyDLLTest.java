package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ListADT;
import utilities.MyDLL;

public class MyDLLTest {

    private MyDLL<String> myDLLString;

    @BeforeMethod
    public void initArray() {
        myDLLString = new MyDLL<>();
    }

    @Test(description = "Checking the method isEmpty() for the true", groups = "MyDLLTest")
    public void testIsEmptyTrue() {
        Assert.assertTrue(myDLLString.isEmpty());
    }


    @Test(description = "Checking the method isEmpty() for the false", groups = "MyDLLTest")
    public void testIsNotEmptyFalse() {
        myDLLString.add("1");
        myDLLString.add("2");
        myDLLString.add("3");
        Assert.assertFalse(myDLLString.isEmpty());
    }

    @Test(description = "Checking the method itoArray(E[] toHold) for the Exception",
            groups = "MyDLLTest")
    public void testItoArrayException() {
        Assert.assertThrows(NullPointerException.class, () -> myDLLString.toArray(null));
    }

    @Test(description = "Checking the method itoArray(E[] toHold)", groups = "MyDLLTest")
    public void testItoArray() {
        String[] ex = {"a", "b", "c"};
        Assert.assertEquals(myDLLString.toArray(ex), ex);
    }

    @Test(description = "Checking the method contains(E toFind) for the Exception",
            groups = "MyDLLTest")
    public void testToFindException() {
        Assert.assertThrows(NullPointerException.class, () -> myDLLString.contains(null));
    }

    @Test(description = "Checking the method contains(E toFind)", groups = "MyDLLTest")
    public void testToFind() {
        myDLLString.add("a");
        myDLLString.add("b");
        myDLLString.add("c");
        Assert.assertTrue(myDLLString.contains("b"));
        Assert.assertFalse(myDLLString.contains("f"));
    }

    @Test(description = "Checking the method Add(E toAdd) for the Exception", groups = "MyDLLTest")
    public void testAddException() {
        Assert.assertThrows(NullPointerException.class, () -> myDLLString.add(null));
    }

    @Test(description = "Checking the method Add(E toAdd))", groups = "MyDLLTest")
    public void testAdd() {
        Assert.assertTrue(myDLLString.add("3"));
    }

    @Test(description = "Checking the method  addAll(ListADT<? extends E> toAdd) for the Exception",
            groups = "MyDLLTest")
    public void testAddAllException() {
        ListADT<String> toAdd = new MyDLL<>();
        Assert.assertThrows(NullPointerException.class, () -> toAdd.add(null));
    }

    @Test(description = "Checking the method  addAll(ListADT<? extends E> toAdd)",
            groups = "MyDLLTest")
    public void testAddAll() {
        ListADT<String> toAdd = new MyDLL<>();
        toAdd.add("a");
        toAdd.add("b");
        myDLLString.addAll(toAdd);
        Assert.assertEquals(myDLLString.toArray(), toAdd.toArray());
    }

    @Test(description = "Checking the method remove(E toRemove) for the Exception",
            groups = "MyDLLTest")
    public void testRemoveException() {
        Assert.assertThrows(NullPointerException.class, () -> myDLLString.remove(null));
    }

    @Test(description = "Checking the method remove(E toRemove)", groups = "MyDLLTest")
    public void testRemove() {
        myDLLString.add("a");
        myDLLString.add("b");
        myDLLString.add("c");
        myDLLString.remove(1);
        String[] expected = {"a", "c"};
        Assert.assertEquals(myDLLString.toArray(), expected);
    }

    @Test(description = "Checking the method add(int index, E toAdd)", groups = "MyDLLTest")
    public void testAddSecond() {
        try {
            myDLLString.add(0, "a");
            myDLLString.add(1, "b");
            myDLLString.add(2, "c");
        } catch (NullPointerException | ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }
        String[] expected = {"a", "b", "c"};
        Assert.assertEquals(myDLLString.toArray(), expected);
    }

    @Test(description = "Checking the method get(int index) for the Exception", groups = "MyDLLTest")
    public void testGetException() {
        myDLLString.add("a");
        myDLLString.add("b");
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> myDLLString.get(3));
    }


    @Test(description = "Checking the method get(int index)", groups = "MyDLLTest")
    public void testGet() {
        myDLLString.add("a");
        myDLLString.add("b");
        myDLLString.add("c");
        Assert.assertEquals(myDLLString.get(2), "c");
        Assert.assertNotEquals(myDLLString.get(2), "a");
    }

    @Test(description = "Checking the method remove(int index) for the Exception",
            groups = "MyDLLTest")
    public void testRemoveSecondException() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> myDLLString.remove(-7));
    }

    @Test(description = "Checking the method remove(int index)", groups = "MyDLLTest")
    public void testRemoveSecond() {
        myDLLString.add("a");
        myDLLString.add("b");
        myDLLString.add("c");
        myDLLString.remove(1);
        String[] expected = {"a", "c"};
        Assert.assertEquals(myDLLString.toArray(), expected);
    }

    @Test(description = "Checking the method set(int index, E toChange) for the Exception",
            groups = "MyDLLTest")
    public void testSetException() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> myDLLString.set(-7, "a"));
        myDLLString.add("a");
        myDLLString.add("b");
        Assert.assertThrows(NullPointerException.class, () -> myDLLString.set(2, null));
    }

    @Test(description = "Checking the method set(int index, E toChange)", groups = "MyDLLTest")
    public void testSet() {
        myDLLString.add("a");
        myDLLString.add("b");
        myDLLString.add("c");
        myDLLString.set(2, "f");
        String[] expected = {"a", "b", "f"};
        Assert.assertEquals(myDLLString.toArray(), expected);
    }
}
