// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package project1;

import student.TestCase;
import bag.BagInterface;

/**
 * DisplayCollectionTest will test all of the methods in DisplayCollection to
 * make
 * sure that they run and perform as expected
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 30, 2018
 */

public class DisplayCollectionTest extends TestCase {

    /**
     * Sets up each test method before it runs
     */
    public void setUp() {
        /**
         * Empty since DisplayCollectionTest class
         * does not contains any fields
         */
    }


    /**
     * Tests the size of the bag for accurate results.
     */
    public void testBagSize() {
        DisplayCollection myCollection = new DisplayCollection();

        for (int i = 0; i <= 20; i++) {
            BagInterface<String> test = myCollection.getItemBag();
            assertTrue((test.getCurrentSize() < 16) && (test
                .getCurrentSize() > 4));
        }

    }


    /**
     * Tests the contents of the bag for accurate results.
     */
    public void testBagContents() {
        DisplayCollection myCollection = new DisplayCollection();
        for (int i = 0; i < 4; i++) {
            assertTrue(myCollection.getItemBag().contains(
                myCollection.STRINGS[i]));
        }
    }

}
