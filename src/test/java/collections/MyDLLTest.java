package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.ListADT;
import utilities.MyArrayList;
import utilities.MyDLL;

import java.util.Arrays;

public class MyDLLTest {
    private   MyDLL<Integer>  myDLLInteger = new MyDLL<>();
    MyDLL<String>  myDLLString;
    private MyDLL<Double>  myDLLDouble = new MyDLL<>();
    private MyDLL<Boolean>  myDLLBoolean = new MyDLL<>();

    @BeforeMethod
    public void initArray() {
        myDLLString = new MyDLL<>();
    }

    @Test(description = "Metod isEmpty()")
    public void testIsEmpty() {
        Assert.assertTrue(myDLLString.isEmpty());
    }


    @Test(description = "Metod isEmpty()")
    public void testIsNotEmpty() {
        myDLLString.add("1");
        myDLLString.add("2");
        myDLLString.add("3");
        Assert.assertFalse(myDLLString.isEmpty());
    }

    @Test(description = "Metod itoArray(E[] toHold)")
    public void testItoArrayEx() {
        Assert.assertThrows(NullPointerException.class, () -> myDLLInteger.toArray(null));
        Assert.assertThrows(NullPointerException.class, () -> myDLLDouble.toArray(null));
        Assert.assertThrows(NullPointerException.class, () -> myDLLString.toArray(null));
        Assert.assertThrows(NullPointerException.class, () -> myDLLBoolean.toArray(null));
    }

    @Test(description = "Metod itoArray(E[] toHold)")
    public void testItoArray() {
        String[] ex = {"a","b"};
        Assert.assertEquals(myDLLString.toArray(ex), ex);
    }

    @Test(description = "Metod contains(E toFind)")
    public void testToFind() {
        myDLLString.add("a");
        myDLLString.add("b");
        myDLLString.add("c");
        Assert.assertTrue(myDLLString.contains("b"));
        Assert.assertFalse(myDLLString.contains("f"));
    }

    @Test(description = "Metod contains(E toFind)")
    public void testToFindEx() {
        Assert.assertThrows(NullPointerException.class, () -> myDLLString.contains(null));
    }

    @Test(description = "Add(E toAdd)")
    public void testAdd() {
        Assert.assertTrue(myDLLString.add("3"));
    }

    @Test(description = "Add(E toAdd)")
    public void testAddEx() {
        Assert.assertThrows(NullPointerException.class, () -> myDLLString.add(null));
    }

    @Test(description = "addAll")
    public void testAddAll() {
        ListADT<String> toAdd = new MyDLL<>();
        toAdd.add("a");
        toAdd.add("b");
        myDLLString.addAll(toAdd);
        Assert.assertEquals(myDLLString.toArray(), toAdd.toArray());
    }

    @Test(description = "remove(E toRemove)")
    public void testRemove() {
        myDLLString.add("a");
        myDLLString.add("b");
        myDLLString.add("c");
        myDLLString.remove(1);
        String[] expected = {"a", "c"};

        Assert.assertEquals(myDLLString.toArray(), expected);
    }

    @Test(description = "add(int index, E toAdd)")
    public void testAddS() {
        myDLLString.add("a");
        myDLLString.add("b");
        Assert.assertTrue(myDLLString.add(myDLLString.size()-1 , "c"));
    }

    @Test(description = "get(int index) ")
    public void testGet() {
        myDLLString.add("a");
        myDLLString.add("b");
        myDLLString.add("c");
        Assert.assertEquals(myDLLString.get(2), "c");
        Assert.assertNotEquals(myDLLString.get(2), "a");
    }

    @Test(description = "set(int index, E toChange)")
    public void testSet() {
        myDLLString.add("a");
        myDLLString.add("b");
        myDLLString.add("c");
        myDLLString.set(2,"f" );
        String[] expected = {"a","b", "f"};
        Assert.assertEquals(myDLLString.toArray(), expected);
    }

}
