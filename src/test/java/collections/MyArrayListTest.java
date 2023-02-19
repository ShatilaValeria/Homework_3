package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.Iterator;
import utilities.ListADT;
import utilities.MyArrayList;

import java.util.ArrayList;

public class MyArrayListTest {

    private MyArrayList<Integer> testingArray;

    @BeforeMethod
    public void initArray() {
        testingArray = new MyArrayList<>();
    }

    @Test(description = "Checking the method size()", groups = "additionTests")
    public void testInitialSize() {
        Assert.assertEquals(testingArray.size(), 0);
    }

    @Test(description = "Checking the method size()", groups = "additionTests")
    public void testSize() {
        testingArray.add(1);
        testingArray.add(2);
        testingArray.add(3);
        Assert.assertEquals(testingArray.size(), 3);
    }

    @Test(description = "Checking the method clear()", groups = "additionTests")
    public void testClear() {
        ListADT<String> listADT = new MyArrayList<>();
        listADT.add("One");
        listADT.add("Two");
        listADT.add("Three");
        listADT.clear();
        Assert.assertTrue(listADT.isEmpty());
    }

    @Test(description = "Checking the method add(int index, E toAdd)" +
            " for the Exception IndexOutOfBoundsException",
            groups = "additionTests")
    public void testAddForIndexOutOfBoundsException() {
        testingArray.add(0, 5);
        testingArray.add(1, 7);
        testingArray.add(2, 8);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testingArray.add(8, 9));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testingArray.add(-2, 2));
    }

    @Test(description = "Checking the method add(int index, E toAdd)" +
            " for the NullPointerException",
            groups = "additionTests")
    public void testAddForNullPointerException() {
        testingArray.add(0, 5);
        testingArray.add(1, 7);
        testingArray.add(2, 8);
        Assert.assertThrows(NullPointerException.class, () -> testingArray.add(3, null));
    }

    @Test(description = "Checking the method add(int index, E toAdd)", groups = "additionTests")
    public void testAddElement() {
        testingArray.add(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(), 1);
        softAssert.assertNotEquals(testingArray.size(), "Один");
        softAssert.assertNotEquals(testingArray.size(), 1.2);
        softAssert.assertEquals(testingArray.get(0).intValue(), 5);
        softAssert.assertAll();
    }

    @Test(description = "Checking the method add(E toAdd) for the Exception",
            groups = "additionTests")
    public void testAddSecondException() {
        Assert.assertThrows(NullPointerException.class, () -> testingArray.add(null));
    }

    @Test(description = "Checking the method add(E toAdd) ",
            groups = "additionTests")
    public void testAddSecond() {
        testingArray.add(5);
        testingArray.add(7);
        testingArray.add(8);
        Assert.assertTrue(testingArray.add(5));
    }

    @Test(description = "Check method addAll(ListADT<? extends E> toAdd) for the Exception", groups = "additionTests")
    public void testAddAllException() {
        Assert.assertThrows(NullPointerException.class, () -> testingArray.addAll(null));
    }

    @Test(description = "Check method addAll(ListADT<? extends E> toAdd)", groups = "additionTests")
    public void testAddAll() {
        ListADT<Integer> toAddList = new MyArrayList<>();
        toAddList.add(5);
        toAddList.add(7);
        toAddList.add(8);
        Assert.assertTrue(testingArray.addAll(toAddList));
    }

    @Test(description = "Check method get()", groups = "additionTests")
    public void testGet() {
        ListADT<String> testingArrayString = new MyArrayList<>();
        testingArrayString.add("a");
        testingArrayString.add("b");
        testingArrayString.add("c");
        Assert.assertEquals(testingArrayString.get(0), "a");
        Assert.assertEquals(testingArrayString.get(1), "b");
        Assert.assertEquals(testingArrayString.get(2), "c");
    }


    @Test(description = "Check method get() for the Exception", groups = "additionTests")
    public void testGetException() {
        testingArray.add(5);
        testingArray.add(7);
        testingArray.add(8);
        testingArray.add(8);
        testingArray.add(8);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testingArray.get(testingArray.size() + 5));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testingArray.get(-5));

    }

    @Test(description = "Check method remove(int index) for the Exception", groups = "additionTests")
    public void testRemoveException() {
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testingArray.remove(-1));
    }

    @Test(description = "Check method remove(int index)", dependsOnMethods = "testAddElement")
    public void testDeleteElement() {
        testingArray.add(5);
        testingArray.remove(0);
        Assert.assertTrue(testingArray.isEmpty());
    }

    @Test(description = "Check method get(int index)", groups = "additionTests")
    public void testGetElement() {
        testingArray.add(10);
        testingArray.add(4);
        Assert.assertEquals(testingArray.get(1).intValue(), 4);
    }


    @Test(description = "Check method get(int index)", groups = "additionTests")
    public void testDeleteElementS() {
        ArrayList<String> firstArrayList = new ArrayList<>();
        firstArrayList.add("test");
        firstArrayList.add("secondTest");
        firstArrayList.add("also test");
        firstArrayList.remove("also test");
        ArrayList<String> secondArrayList = new ArrayList<>();
        secondArrayList.add("test");
        secondArrayList.add("secondTest");
        Assert.assertEquals(firstArrayList.toArray(), secondArrayList.toArray());
    }

    @Test(description = "Check method  set(int index, E toChange)", groups = "additionTests")
    public void testSetElement() {
        testingArray.add(10);
        testingArray.add(4);
        testingArray.set(0, 2);
        Assert.assertEquals(testingArray.get(0).intValue(), 2);
    }

    @Test(description = "Check method  set(int index, E toChange) for the Exception", groups = "additionTests")
    public void testSetElementException() {
        testingArray.add(10);
        testingArray.add(4);
        testingArray.add(4);
        testingArray.add(4);
        //Assert.assertThrows(NullPointerException.class, () -> testingArray.set(, null));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testingArray.set(-2, 3));
    }

    @Test(description = "Check method isEmpty()", groups = "additionTests")
    public void testIsEmpty() {
        testingArray.isEmpty();
        Assert.assertEquals(testingArray.size(), 0);
    }

    @Test(description = "Check method contains(E toFind) for the Exception", groups = "additionTests")
    public void testContainsException() {
        Assert.assertFalse(testingArray.contains(null));
    }

    @Test(description = "Check method contains(E toFind)", groups = "additionTests")
    public void testContains() {
        testingArray.add(1);
        testingArray.add(2);
        testingArray.add(3);
        Assert.assertTrue(testingArray.contains(2));
        Assert.assertFalse(testingArray.contains(4));
    }

    @Test(description = "Check method toArray(E[] toHold) for the Exception", groups = "additionTests")
    public void testToArrayException() {
        Assert.assertThrows(NullPointerException.class, () -> testingArray.toArray(null));
    }

    @Test(description = "Check method toArray(E[] toHold)", groups = "additionTests")
    public void testToArray() {
        ListADT<String> list = new MyArrayList<>();
        String[] array = {"1", "2", "3"};
        Assert.assertEquals(list.toArray(array), array);
    }

    @Test(description = "Check method iterator()", groups = "additionTests")
    public void testIterator() {
        testingArray.add(1);
        testingArray.add(2);
        testingArray.add(3);
        ListADT<Integer> checkList = new MyArrayList<>();

        Iterator<Integer> iterator = testingArray.iterator();
        while (iterator.hasNext()) {
            checkList.add(iterator.next());
        }

        Assert.assertEquals(testingArray.toArray(), checkList.toArray());
    }
}

