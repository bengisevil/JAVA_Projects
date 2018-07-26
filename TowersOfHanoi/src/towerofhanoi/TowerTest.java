// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package towerofhanoi;

import student.TestCase;

/**
 * TowerTest tests the methods defined in the Tower
 * class for accurate results.
 * 
 * @author Bengi Sevil
 * @version 06.14.2018
 */

public class TowerTest extends TestCase {
    private Tower test;


    /**
     * Initializes test and creates a new object of type
     * tower with position Position.RIGHT.
     */
    public void setUp() {
        test = new Tower(Position.RIGHT);
    }


    /**
     * Tests the position method for accurate results.
     */
    public void testPosition() {
        assertEquals(Position.RIGHT, test.position());
    }


    /**
     * Tests push for adding new discs.
     */
    public void testPush() {
        Disc small = new Disc(10);
        Disc large = new Disc(20);

        test.push(small);
        assertEquals(10, test.peek().getWidth());

        Exception exception = null;
        try {
            test.push(large);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

        try {
            test.push(null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

        try {
            test.push(small);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);

        test.pop();
        test.push(large);
        test.push(small);

        assertEquals(10, test.peek().getWidth());

    }
}
