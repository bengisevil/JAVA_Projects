// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package towerofhanoi;

import CS2114.Window;
import CS2114.WindowSide;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import CS2114.Button;
import CS2114.Shape;

/**
 * GameWindow represents the GUI interface that contains the
 * graphical representation of the TowersOfHanoi game.
 * 
 * @author Bengi Sevil
 * @version 06.14.2018
 *
 */
public class GameWindow implements Observer {
    private Window window;
    private Shape left;
    private Shape right;
    private Shape middle;
    private HanoiSolver game;
    private static final int DISC_GAP = 8;
    public static final int DISC_HEIGHT = 8;
    private Shape left_base;
    private Shape right_base;
    private Shape middle_base;


    /**
     * Default constructor of the GameWindow. Creates a new GameWindow
     * object. Initializes all private fields with the proper parameters.
     * Adds discs to the towers, declares and initializes the solve button
     * and adds everything to the window.
     * 
     * @param game
     *            Towers of Hanoi game.
     */
    @SuppressWarnings("deprecation")
    public GameWindow(HanoiSolver game) {
        this.game = game;
        game.addObserver(this);
        window = new Window("Tower of Hanoi");
        left = new Shape(185, 150, 5, 150, Color.BLACK);
        middle = new Shape(305, 150, 5, 150, Color.BLACK);
        right = new Shape(425, 150, 5, 150, Color.BLACK);

        left_base = new Shape(142, 300, 90, 7, Color.BLACK);
        middle_base = new Shape(262, 300, 90, 7, Color.BLACK);
        right_base = new Shape(382, 300, 90, 7, Color.BLACK);

        // Initial state when there are no discs on the poles

        for (int i = game.discs(); i > 0; i--) {
            Disc disc = new Disc(i * 10);
            game.getTower(Position.LEFT).push(disc);
            moveDisc(Position.LEFT);
        }

        window.addShape(left);
        window.addShape(middle);
        window.addShape(right);
        window.addShape(left_base);
        window.addShape(middle_base);
        window.addShape(right_base);

        Button solve = new Button("Solve");
        window.addButton(solve, WindowSide.SOUTH);
        solve.onClick(this, "clickedSolve");

    }


    /**
     * The update method for the observable class.
     * Moves the disc on the screen as the solve method of the
     * HanoiSolver class gets executed.
     * 
     * @param o
     *            The observable object.
     * @param arg
     *            Position of the tower.
     */
    @Override
    public void update(Observable o, Object arg) {
        if (arg.getClass() == Position.class) {
            Position pos = (Position)arg;
            Shape temp = game.getTower(pos).peek();
            // window.removeShape(temp);
            moveDisc(pos);
            sleep();
        }
    }


    /**
     * Handles the case when the solve button is clicked on
     * the GUI window. This button invokes the solve method
     * of the game variable.
     * 
     * @param button
     *            The solve button.
     */
    public void clickedSolve(Button button) {
        button.disable();
        new Thread() {
            public void run() {
                game.solve();
            }
        }.start();
    }


    /**
     * Uses the sleep method of the thread to pause between
     * disc movements for visibility purposes on the GUI interface.
     */
    private void sleep() {
        try {
            Thread.sleep(500);

        }
        catch (Exception e) {

        }
    }


    /**
     * Updates the front end after the back end has been
     * changed. Changes the visual positionings of the discs
     * on the GUI window.
     * 
     * @param pos
     *            Position of the tower.
     */
    private void moveDisc(Position pos) {
        int width = game.getTower(pos).peek().getWidth();
        Shape currPole;
        Shape currPoleBase;
        // Store the current disc
        Disc currDisc = game.getTower(pos).peek();
        // Store the pole associated with the move
        if (pos == Position.LEFT) {
            currPole = left;
            currPoleBase = left_base;
        }
        else if (pos == Position.MIDDLE) {
            currPole = middle;
            currPoleBase = middle_base;
        }
        else {
            currPole = right;
            currPoleBase = right_base;
        }

        currDisc.moveTo(currPoleBase.getX() + (currPole.getX() - currPoleBase
            .getX()) - (width / 2) + currPole.getWidth() / 2, currPoleBase
                .getY() - 1 - (DISC_GAP * game.getTower(pos).size() - 1));
        window.addShape(currDisc);
        window.moveToFront(currDisc);
    }
}
