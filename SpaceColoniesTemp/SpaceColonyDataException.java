// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

/**
 * This will be thrown if data is incorrect in the input files.
 * 
 * @author Bengi Sevil
 * @version 06.20.2018
 *
 */
public class SpaceColonyDataException extends Exception {
    /**
     * Calls the super constructor with the parameter
     * message to handle the exception.
     * 
     * @param message
     *            The exception message.
     */
    public SpaceColonyDataException(String message) {
        super(message);
    }
}
