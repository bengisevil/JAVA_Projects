// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package towerofhanoi;

/**
 * This class contains the main method that will
 * run the Towers of Hanoi game.
 * .
 * 
 * @author Bengi Sevil
 * @version 06.14.2018
 *
 */
public class ProjectRunner {
    /**
     * The main method that runs this program.
     * Creates a new GameWindow, and HanoiSolver
     * object. Creates 5 discs by default if no
     * argument is provided, or in the amount of
     * the number provided.
     * 
     * 
     * @param args
     */
    public static void main(String[] args) {
        int numOfDiscs = 5;
        if (args.length == 1) {
            numOfDiscs = Integer.parseInt(args[0]);
        }
        HanoiSolver game = new HanoiSolver(numOfDiscs);
        GameWindow window = new GameWindow(game);
    }
}
