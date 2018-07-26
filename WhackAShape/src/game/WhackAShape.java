// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package game;

import bag.SimpleBagInterface;
import CS2114.Window;
import CS2114.WindowSide;
import CS2114.Shape;
import CS2114.SquareShape;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.TextShape;
import student.TestableRandom;
import java.awt.Color;
import java.util.stream.IntStream;;

/**
 * WhackAShape is a game where the shapes in a bag is
 * displayed one by one as the user clicks on the shapes
 * on the window. The game ends when there are no more
 * shapes to display.
 *
 * @author Bengi Sevil bsevil18
 * @version 06.06.2018
 * 
 */
public class WhackAShape {
    private SimpleArrayBag<Shape> bag;
    private Window window;
    private TestableRandom randomGenerator;


    /**
     * WhackAShape default constructor. Creates a new
     * object of this type and initializes private fields.
     * 
     * Adds a quit button to the north side of the window,
     * adds 4 shapes to the bag and displays the first shape
     * on the window by randomly picking a shape from the bag
     * with pick().
     *
     */
    public WhackAShape() {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        randomGenerator = new TestableRandom();

        Button quitButton = new Button("Quit");
        window.addButton(quitButton, WindowSide.NORTH);

        quitButton.onClick(this, "clickedQuit");

        bag.add(buildShape("red circle"));
        bag.add(buildShape("red square"));
        bag.add(buildShape("blue circle"));
        bag.add(buildShape("blue square"));

        Shape shape = bag.pick();
        window.addShape(shape);
        bag.remove(shape);

    }


    /**
     * Parameterized Constructor of the WhackAShape class.
     * Performs the same setup steps as the default constructor,
     * except for the addition of shapes to the bag. This constructor
     * adds the shapes as given in the str argument, and displays
     * a random selection on the window with pick.
     */
    public WhackAShape(String[] str) {
        bag = new SimpleArrayBag<Shape>();
        window = new Window();
        randomGenerator = new TestableRandom();

        Button quitButton = new Button("Quit");
        window.addButton(quitButton, WindowSide.NORTH);

        quitButton.onClick(this, "clickedQuit");
        Shape shape = null;

        for (int i = 0; i < str.length; i++) {
            try {
                shape = buildShape(str[i]);
            }
            catch (IllegalArgumentException e) {
                e.printStackTrace();
            }

            bag.add(shape);
        }

        window.addShape(bag.pick());

    }


    /**
     * This method simply returns the bag field of WhackAShape.
     * 
     * @return bag
     */
    public SimpleBagInterface<Shape> getBag() {
        return bag;

    }


    /**
     * This method simply returns the window field of WhackAShape.
     * 
     * @return window
     */
    public Window getWindow() {
        return window;
    }


    /**
     * Quit button handler function.
     * Exits out of the window with System.exit(0) when the quit
     * button is clicked. The 0 parameter indicates there were no
     * errors encountered.
     * 
     * @param quit
     *            The quit button on the window.
     */
    public void clickedQuit(Button quit) {
        System.exit(0);
    }


    /**
     * The handler function for a shape being clicked on the window.
     * Shape gets removed from the window with removeShape and from the bag with
     * remove(), and a new shape is selected with the method pick(). The new
     * shape
     * gets displayed on the window. When the bag is empty, a new TextShape
     * "You Win!" gets displayed.
     * 
     * @param shape
     *            The shape that was clicked on the window.
     */
    public void clickedShape(Shape shape) {
        window.removeShape(shape);
        bag.remove(shape);

        if (bag.isEmpty()) {
            int x = window.getGraphPanelWidth() / 2 - 30;
            int y = window.getGraphPanelHeight() / 2 - 10;
            TextShape done = new TextShape(x, y, "You Win!");
            window.addShape(done);
        }
        else {
            Shape nextShape = bag.pick();
            window.addShape(nextShape);
        }
    }


    /**
     * Helper private function that parses the input string to
     * determine what shape needs to be drawn and what color. Throws
     * an IllegalArgumentException if the input is not one of the following:
     * red circle, blue circle, red square, blue square.
     * The coordinates of the circle or square is determined by a randomly
     * generated width and height number between 100-200.
     * Invokes clickedShape() to handle onclick events for the shape being
     * created.
     * 
     * @param input
     *            String representation of the shape being
     *            requested to be drawn.
     * @return The shape object be drawn on the window;
     *         Red circle, blue circle, red square or blue square.
     * @throws IllegalArgumentException
     */
    private Shape buildShape(String input) throws IllegalArgumentException {

        input = input.toLowerCase();

        TestableRandom r = new TestableRandom();
        int size = r.nextInt(100);
        size += 100;

        int width = window.getGraphPanelWidth();
        int height = window.getGraphPanelHeight();

        int x = r.nextInt(width);
        int y = r.nextInt(height);

        if ((size + x) > width || (x == width)) {
            x -= size;
        }
        if ((size + y) > height || (y == 0)) {
            y -= size;
        }
        if (x == 0 && y == 0) {
            y += size;
            x += size;
        }

        window.getGraphPanelWidth();
        Shape currentShape;

        if (input.equals("red circle")) {
            currentShape = new CircleShape(x, y, size, Color.RED);
        }
        else if (input.equals("blue circle")) {
            currentShape = new CircleShape(x, y, size, Color.BLUE);
        }
        else if (input.equals("red square")) {
            currentShape = new SquareShape(x, y, size, Color.RED);
        }
        else if (input.equals("blue square")) {
            currentShape = new SquareShape(x, y, size, Color.BLUE);
        }
        else {
            throw new IllegalArgumentException();
        }

        currentShape.onClick(this, "clickedShape");
        return currentShape;
    }
}
