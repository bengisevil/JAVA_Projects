// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

import student.TestCase;

/**
 * This class tests the methods in the Skills class.
 * 
 * @author Bengi Sevil
 * @version 06.19.2018
 *
 */
public class SkillsTest extends TestCase {
    private Skills test1;
    private Skills test2;
    private Skills test3;


    /**
     * Creates a new Skills object.
     */
    public void setUp() {
        test1 = new Skills(2, 4, 3);
        test2 = new Skills(1, 1, 1);
        test3 = new Skills(5, 5, 5);
    }


    /**
     * Tests the getAgriculture method for accurate
     * results.
     */
    public void testGetAgriculture() {
        assertEquals(2, test1.getAgriculture());
    }


    /**
     * Tests the getMedicine method for accurate
     * results.
     */
    public void testGetMedicine() {
        assertEquals(4, test1.getMedicine());
    }


    /**
     * Tests the getTechnology method for accurate
     * results.
     */
    public void testGetTechnology() {
        assertEquals(3, test1.getTechnology());
    }


    /**
     * Tests the isBelow method for accurate results.
     */
    public void testIsBelow() {
        Skills temp2 = new Skills(1, 1, 5);
        Skills temp3 = new Skills(1, 4, 4);
        assertTrue(test2.isBelow(test1));
        assertTrue(test2.isBelow(test1));
        assertFalse(temp2.isBelow(test2));
        assertFalse(temp3.isBelow(test2));
        assertFalse(test3.isBelow(test1));
        
    }


    /**
     * Tests toString method for accurate results.
     */
    public void testToString() {
        assertEquals("A:1 M:1 T:1", test2.toString());
    }


    /**
     * Tests equals method for accurate results.
     */
    public void testEquals() {
        Skills temp = new Skills(1, 1, 1);
        Skills temp2 = new Skills(1, 1, 5);
        Skills temp3 = new Skills(1, 4, 4);
        assertFalse(test1.equals(null));
        assertTrue(test1.equals(test1));
        assertFalse(test1.equals("a"));
        assertFalse(test1.equals(test2));
        assertFalse(test2.equals(temp2));
        assertFalse(test2.equals(temp3));
        assertTrue(test2.equals(temp));

    }
}
