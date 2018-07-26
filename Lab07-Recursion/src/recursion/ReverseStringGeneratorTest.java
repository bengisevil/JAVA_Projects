package recursion;

import student.TestCase;

/**
 * ReverseStringGeneratorTest class tests the ReverseStringGenerator class
 * to ensure all methods work accurately.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.06.2018
 * 
 */

public class ReverseStringGeneratorTest extends TestCase {

    /**
     * Sets up variables to be tested.
     */
    public void setUp() {
        new ReverseStringGenerator();
    }


    /**
     * Tests reverse method to check if it correctly
     * reverses a given string.
     */
    public void testReverse() {
        assertEquals("", ReverseStringGenerator.reverse(""));
        assertEquals("a", ReverseStringGenerator.reverse("a"));
        assertEquals("ab", ReverseStringGenerator.reverse("ba"));
        assertEquals("enuj", ReverseStringGenerator.reverse("june"));
    }

}
