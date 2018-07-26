// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package game;

import game.WhackAShape;

/**
 * ProjectRunner has the main method that runs the WhackAShape
 * class as an application.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.10.2018
 * 
 */
public class ProjectRunner {

    /**
     * One class in a program can have a main method.
     * It is the entry point for a program if it is run
     * as an application.
     * 
     * A new WhackAShape object is created.
     * If a string argument is provided, then the parameterized
     * constructor is called. Otherwise, the default constructor
     * is called.
     * 
     * @param args
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            WhackAShape inst = new WhackAShape(args);
        }
        else {
            WhackAShape inst = new WhackAShape();
        }
    }

}
