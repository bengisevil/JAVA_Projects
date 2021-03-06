// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package towerofhanoi;

import student.TestCase;

/**
 * The DiscTest class tests all the methods in the class Disc
 * for accurate behavior.
 * 
 * @author Bengi Sevil
 * @version 06.14.2018
 */
public class DiscTest extends TestCase {

    private Disc test;


    /**
     * Initializes the test variable.
     */
    public void setUp() {
        test = new Disc(5);
    }


    /**
     * Tests the compareTo method to compare
     * the width values of discs.
     */
    public void testCompareTo() {
        Disc larger = new Disc(10);
        Disc smaller = new Disc(2);

        assertEquals(-1, test.compareTo(larger));
        assertEquals(1, test.compareTo(smaller));
        assertEquals(0, test.compareTo(test));

        Exception exception = null;
        try {
            test.compareTo(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

    }


    /**
     * Tests the equals method for accurate behavior.
     */
    public void testEquals() {
        Disc obj = null;
        assertTrue(test.equals(test));
        assertFalse(test.equals(obj));
        assertFalse(test.equals("other"));

        Disc larger = new Disc(10);
        Disc same = new Disc(5);

        assertFalse(test.equals(larger));
        assertTrue(test.equals(same));

    }


    /**
     * Tests the toString method to return the string
     * representation of the current width.
     */
    public void testToString() {
        assertEquals("5", test.toString());
    }

}
