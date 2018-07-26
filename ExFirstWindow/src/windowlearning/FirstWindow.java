package windowlearning;


import java.awt.Color;
import CS2114.Window;
import CS2114.Button;
import CS2114.Shape;
import CS2114.WindowSide;

/**
 * The {@link FirstWindow} class provides a simple GUI that displays a
 *  square shape centered at the top of the window. Red and Yellow Buttons
 * can be used to change the foreground color of the shape.
 * 
 * @author maellis1
 * @version 01.22.2016
 */
public class FirstWindow {

	private Window window;
	private Shape shape;
	private Button redButton;
	private Button yellowButton;
	/** width of the window **/
	public static final int WINDOW_WIDTH = 500;
	/** height of the window **/
	public static final int WINDOW_HEIGHT = 700;

	/**
	 * Creates a new instance of the {@link FirstWindow} class.
	 * 
	 */
	public FirstWindow() {

		window = new Window();
		window.setTitle("First Window");
		window.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);  
		shape = new Shape(window.getGraphPanelWidth()/2, 0,Color.MAGENTA);
		//shape.move(-shape.getWidth()/2, 0);
		

		redButton = new Button("Red");
		redButton.onClick(this, "clickedRed");

		yellowButton = new Button("Yellow");
		yellowButton.onClick(this, "clickedYellow");

		window.addShape(shape);
		window.addButton(redButton, WindowSide.SOUTH);
		window.addButton(yellowButton, WindowSide.SOUTH);
	}

	/**
	 * Event handler for the "Red" button. Changes the shape's color to red.
	 * 
	 * @param source
	 *            the button that originates the event.
	 */
	public void clickedRed(Button source) {

		shape.setBackgroundColor(Color.RED);
	}

	/**
	 * Event handler for the "Yellow" button. 
	 * Changes the shape's color to yellow.
	 * 
	 * @param source
	 *            the button that originates the event.
	 */
	public void clickedYellow(Button source) {

		shape.setBackgroundColor(Color.YELLOW);
	}
	
	public static void main(String[] args) {
		new FirstWindow();
	}


}
