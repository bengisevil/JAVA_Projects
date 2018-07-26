// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package game;

import student.TestCase;

/**
 * SimpleLinkedBagTest class tests the SimpleLinkedBag class
 * to ensure all methods work accurately. A linked bag with String
 * type items is used for testing.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.10.2018
 * 
 */

public class SimpleLinkedBagTest extends TestCase {

    private SimpleLinkedBag<String> test;


    /**
     * Instantiates an instance of SimpleLinkedBag called test
     * with items of type string.
     */
    public void setUp() {
        test = new SimpleLinkedBag<String>();
    }


    /**
     * Tests the add method for accurate results.
     * Addition is expected to be false for when the item
     * to be added is null, and to return true otherwise.
     * Both cases are tested.
     */
    public void testAdd() {
        // Test case 1: Adding a null item
        assertFalse(test.add(null));

        // Test case 2: Regular addition to the bag.
        assertTrue(test.add("apple"));
        assertEquals(1, test.getCurrentSize());

    }


    /**
     * Tests the getCurrentSize method to check if it returns
     * the number of items in the bag.
     */
    public void testGetCurrentSize() {
        assertEquals(0, test.getCurrentSize());
        test.add("item");
        assertEquals(1, test.getCurrentSize());
        test.add("item");
        test.add("item");
        assertEquals(3, test.getCurrentSize());

    }


    /**
     * Tests isEmpty to check if it returns true when the bag is
     * empty and false otherwise.
     */
    public void testIsEmpty() {
        assertTrue(test.isEmpty());
        test.add("item");
        assertFalse(test.isEmpty());
    }


    /**
     * Tests pick to test if it returns the item at any of the first
     * 0-9th position in the array bag; Also tests for the empty bag case.
     */
    public void testPick() {
        assertEquals(null, test.pick());
        test.add("item0");
        test.add("item1");
        test.add("item2");
        test.add("item3");
        test.add("item4");
        test.add("item5");
        test.add("item6");
        test.add("item7");
        test.add("item8");
        test.add("item9");
        String item = test.pick();
        assertTrue(item.contains("item"));

    }


    /**
     * Tests the remove method and its helper method getReferenceTo.
     * The method is tested with an empty bag, with an attempt
     * to remove a non-existing and an existing item.
     */
    public void testRemove() {
        // Empty bag
        assertFalse(test.remove("item"));
        assertEquals(0, test.getCurrentSize());

        // Removing an existing item
        test.add("item0");
        test.add("item1");
        test.add("item2");
        assertTrue(test.remove("item2"));
        assertEquals(2, test.getCurrentSize());

        // Removing a non-existing item
        assertFalse(test.remove("non-existent"));
    }

}
