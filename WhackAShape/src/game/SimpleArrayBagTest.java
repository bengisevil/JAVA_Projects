// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package game;

import student.TestCase;

/**
 * SimpleArrayBagTest class tests the SimpleArrayBag class
 * to ensure all methods work accurately. An array bag with String
 * type items is used for testing.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.10.2018
 * 
 */

public class SimpleArrayBagTest extends TestCase {

    private SimpleArrayBag<String> test;


    /**
     * Instantiates an instance of SimpleArrayBag called test
     * with items of type string.
     */
    public void setUp() {
        test = new SimpleArrayBag<String>();
    }


    /**
     * Tests the add method for accurate results.
     * Addition is expected to be false for when the bag is full
     * or the item to be added is null, and to return true otherwise.
     * All 3 cases are tested.
     */
    public void testAdd() {
        // Test case 1: Adding a null item
        assertFalse(test.add(null));

        // Test case 2: Regular addition to the bag.
        assertTrue(test.add("apple"));
        assertEquals(1, test.getCurrentSize());

        // Test case 3: Addition to a full bag.
        int i = 0;
        while (i < 24) {
            test.add("items");
            i++;
        }
        assertFalse(test.add("full"));
        assertEquals(25, test.getCurrentSize());
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
     * Tests the remove method and its helper method getIndexOf.
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
