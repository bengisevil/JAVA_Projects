// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package project1;

import bag.Bag;
import bag.BagInterface;
import CS2114.TextShape;
import java.awt.Color;
import java.util.Random;
import CS2114.Window;
import CS2114.WindowSide;
import CS2114.Button;

/**
 * ShapeWindow class contains the GUI functionality of this project.
 * It contains 5 fields: a Window, two Buttons, a TextShape and a Bag.
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 30, 2018
 */
public class ShapeWindow {
    private Window window;
    private TextShape textShape;
    private Button quitButton;
    private Button chooseButton;
    private BagInterface<String> itemBag;
    private String text;


    // ----------------------------------------------------------
    /**
     * Create a new ShapeWindow object.
     */
    public ShapeWindow(BagInterface<String> bag) {
        itemBag = new Bag<String>();
        itemBag = bag;

        text = "";

        window = new Window("Project 1");
        textShape = new TextShape(0, 0, "");
        quitButton = new Button("Quit");
        chooseButton = new Button("Choose");

        window.addShape(textShape);

        quitButton.onClick(this, "clickedQuit");
        chooseButton.onClick(this, "clickedChoose");

        window.addButton(quitButton, WindowSide.NORTH);
        window.addButton(chooseButton, WindowSide.SOUTH);

    }


    /**
     * Click the quit button.
     * 
     * @param quitButton
     *            The button to be clicked.
     */
    public void clickedQuit(Button quitButton) {
        System.exit(0); // 0 indicates no errors occured
    }


    /**
     * Click the choose button.
     * 
     * @param chooseButton
     *            The button to be clicked.
     */
    public void clickedChoose(Button chooseButton) {
        if (!itemBag.isEmpty()) {
            text = itemBag.remove();
            textShape.setText(text);
        }
        else {
            text = "No more items.";
            textShape.setText(text);
        }
        colorText();
        centerText();
    }


    /**
     * Set text color.
     * 
     */
    public void colorText() {
        if (text.contains("red")) {
            textShape.setForegroundColor(Color.RED);
        }
        else if (text.contains("blue")) {
            textShape.setForegroundColor(Color.BLUE);
        }
        else {
            textShape.setForegroundColor(Color.BLACK);
        }
    }


    /**
     * Center text.
     * 
     */
    public void centerText() {
        int windowWidth = window.getGraphPanelWidth();
        int windowHeight = window.getGraphPanelHeight();

        int textW = textShape.getWidth();
        int textH = textShape.getHeight();

        textShape.moveTo((windowWidth / 2) - (textW / 2), (windowHeight / 2)
            - (textH / 2));

    }
}
