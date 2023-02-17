package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.ListADT;
import utilities.MyArrayList;

import java.util.ArrayList;

public class MyArrayListTest {

    private MyArrayList<Integer> testingArray;

    @BeforeMethod
    public void initArray() {
        testingArray = new MyArrayList<>();
    }

    @Test
    public void testInitialSize() {
        Assert.assertEquals(testingArray.size(), 0);
    }

    @Test(groups = "additionTests")
    public void testAddElement() {
        testingArray.add(5);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(), 1);
        softAssert.assertNotEquals(testingArray.size(), "Один");
        softAssert.assertNotEquals(testingArray.size(), 1.2);
        softAssert.assertEquals(testingArray.get(0).intValue(), 5);
        softAssert.assertAll();
    }

//    @Test(description = "Check Exeption", expectedExceptions = IndexOutOfBoundsException.class)
//    public void testExept(){
//        testingArray.add(5);
//
//        testingArray.get(10);
//
//    }

    @Test(description = "Check metod get ()")
    public void testGet(){
        testingArray.add(5);
        testingArray.add(7);
        testingArray.add(8);
        testingArray.add(8);
        testingArray.add(8);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testingArray.get(testingArray.size()+ 5));

    }

    @Test(description = "Check metod add(int index, E toAdd)")
    public void testAdd(){
        testingArray.add(5);
        testingArray.add(7);
        testingArray.add(8);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testingArray.add(8, 9));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> testingArray.add(-2, 2));

    }

    @Test(description = "Check metod addAll(ListADT<? extends E> toAdd)")
    public void testAddAll(){
        ListADT<Integer> toAddList = new MyArrayList<>();
        toAddList.add(5);
        toAddList.add(7);
        toAddList.add(8);
        Assert.assertTrue(testingArray.addAll(toAddList));
        Assert.assertThrows(NullPointerException.class, () -> testingArray.addAll(null));
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testDeleteElement() {
        testingArray.add(5);
        testingArray.remove(0);
        Assert.assertTrue(testingArray.isEmpty());
    }

    @Test(dependsOnMethods = "testAddElement")
    public void testGetElement() {
        testingArray.add(10);
        testingArray.add(4);
        Assert.assertEquals(testingArray.get(1).intValue(), 4);
    }


    @Test(dependsOnMethods = "remove(E toRemove)")
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

    @Test(dependsOnMethods = "testAddElement")
    public void testSetElement() {
        testingArray.add(10);
        testingArray.add(4);
        testingArray.set(0,2);
        Assert.assertEquals(testingArray.get(0).intValue(), 2);
    }

    @Test(dependsOnMethods = "isEmpty()")
    public void testIsEmpty(){
        Assert.assertTrue(testingArray.isEmpty());
    }

    @Test(dependsOnMethods = "contains(E toFind)")
    public void testContains(){
        testingArray.add(1);
        testingArray.add(2);
        testingArray.add(3);
       // Assert.assertTrue(testingArray.contains(2));
        Assert.assertTrue(testingArray.contains(1));
    }
}

