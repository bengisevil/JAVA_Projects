// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

import student.TestCase;

/**
 * This class tests the methods in the SpaceColonyException class.
 * 
 * @author Bengi Sevil
 * @version 06.19.2018
 *
 */
public class SpaceColonyDataExceptionTest extends TestCase {
    private SpaceColonyDataException e;


    /**
     * Creates a new Skills object.
     */
    public void setUp() {
        e = new SpaceColonyDataException("error");
    }
}
