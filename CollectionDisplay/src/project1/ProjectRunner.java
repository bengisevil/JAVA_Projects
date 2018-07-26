// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package project1;

/**
 * ShapeWindow class contains the GUI functionality of this project.
 * It contains 5 fields: a Window, two Buttons, a TextShape and a Bag.
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 30, 2018
 */

public class ProjectRunner {

    // ----------------------------------------------------------

    /**
     * One class in a program can have a main method.
     * It is the entry point for a program if it is run as an application
     * 
     * @param args
     */
    public static void main(String[] args) {
        DisplayCollection myCollection = new DisplayCollection();
        ShapeWindow myWindow = new ShapeWindow(myCollection.getItemBag());
    }
}
