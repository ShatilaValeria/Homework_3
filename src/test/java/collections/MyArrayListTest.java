package collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.MyArrayList;

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

    @Test
    public void testEl(){
        testingArray.add(2);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(testingArray.size(),1);
        Assert.assertNotEquals(testingArray.size(), "sdfgh");
        Assert.assertNotEquals(testingArray.size(), 1.2);
    }

}

