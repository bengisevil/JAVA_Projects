// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

import java.awt.Color;
import CS2114.Shape;
import CS2114.Button;
import CS2114.CircleShape;
import CS2114.TextShape;
import CS2114.Window;
import CS2114.WindowSide;
import list.AList;

/**
 * This object is the front end. Here we build our window, its buttons, and
 * render the Planets and the queue of applicants on the window in a meaningful
 * way.
 * 
 * @author Bengi Sevil
 * @version 06.20.2018
 *
 */
public class SpaceWindow {
    private Window window;
    private ColonyCalculator colonyCalculator;
    private Button accept;
    private Button reject;
    private Color[] colors;


    /**
     * Creates a new SpaceWindow class and initializes all fields.
     * Initializes all private fields. Creates a color array to
     * color code planets.
     * Yellow: No Planet Preference
     * Pink: Planet1
     * Purple: Planet2
     * Blue: Planet3
     * 
     * @param calculator
     *            The calculator object being passed.
     */
    public SpaceWindow(ColonyCalculator calculator) {

        window = new Window("Space Colony Placement");
        accept = new Button("ACCEPT");
        reject = new Button("REJECT");
        colonyCalculator = calculator;

        // More colors can be declared if default NUM_PLANETS
        // is changed by the programmer.
        Color colorNoPlanet = new Color(255, 255, 0);
        Color colorPlanet1 = new Color(255, 102, 178);
        Color colorPlanet2 = new Color(204, 153, 255);
        Color colorPlanet3 = new Color(153, 204, 255);

        colors = new Color[ColonyCalculator.NUM_PLANETS + 1];
        colors[0] = colorNoPlanet;
        colors[1] = colorPlanet1;
        colors[2] = colorPlanet2;
        colors[3] = colorPlanet3;

        window.addButton(accept, WindowSide.SOUTH);
        window.addButton(reject, WindowSide.SOUTH);

        accept.onClick(this, "clickedAccept");
        reject.onClick(this, "clickedReject");

        // Initial window setup
        updateWindowPlanets();
        updateWindowApplicantQueue();
        updateWindowApplicantInfo();
    }


    /**
     * Attempts to accept the next person in line by calling
     * the calculator function accept(). If successful, the window
     * updates. Otherwise, accept button gets disabled to force the user
     * to reject, but the reject function is not called.
     * 
     * @param accept
     */
    public void clickedAccept(Button accept) {
        if (!colonyCalculator.accept()) {
            accept.disable();
        }
        else {
            updateWindow();
        }
    }


    /**
     * The handler method of the reject button click. Calls the
     * reject method of the colonyCalculator and updates the window.
     * Re-enables the accept button.
     * 
     * @param reject
     */
    public void clickedReject(Button reject) {
        colonyCalculator.reject();
        updateWindow();
        accept.enable();
    }


    /**
     * The general function updateWindow that calls all the sub methods
     * that updates the queue visual, planet info and visual, and applicant
     * information.
     * 
     * If the queue is empty, calls the gameOver method to finish the program.
     */
    private void updateWindow() {
        window.removeAllShapes();
        if (colonyCalculator.getQueue().isEmpty()) {
            reject.disable();
            accept.disable();
            gameOver();
        }
        updateWindowApplicantQueue();
        updateWindowApplicantInfo();
        updateWindowPlanets();
    }


    /**
     * Updates the window to display finished message in the center of the
     * window.
     */
    private void gameOver() {
        int x = window.getGraphPanelWidth() / 4;
        int y = window.getGraphPanelHeight() / 2;
        String information = "All Applicants Processed - Good Work!";
        TextShape info = new TextShape(x, y, information);
        info.setBackgroundColor(Color.pink);
        window.addShape(info);
    }


    /**
     * Updates the applicant queue on the window.
     */
    public void updateWindowApplicantQueue() {
        int start_x = 50;
        int start_y = 50;
        int offset = 0;
        int circle_size = 40;

        Object[] applicantQueue = colonyCalculator.getQueue().toArray();
        AList<CircleShape> personCircles = new AList<CircleShape>();

        int queueSize = applicantQueue.length;
        for (int i = 0; i < queueSize; i++) {
            Person curPerson = (Person)applicantQueue[i];
            int planetIndex = colonyCalculator.getPlanetIndex(curPerson
                .getPlanetName());
            if (colonyCalculator.planetByNumber(planetIndex) == null) {
                planetIndex = 0;
            }
            CircleShape person = new CircleShape(start_x + offset, start_y,
                circle_size, colors[planetIndex]);
            personCircles.add(person);
            offset += 50;
        }

        queueSize = personCircles.getLength();
        for (int i = 0; i < queueSize; i++) {
            window.addShape(personCircles.remove(0));
        }
    }


    /**
     * Displays the information of the first person in the queue on
     * top of the screen.
     */
    private void updateWindowApplicantInfo() {
        window.repaint();
        int start_x = 10;
        String information = colonyCalculator.getQueue().getFront().toString();
        TextShape info = new TextShape(start_x, start_x, information);
        info.setBackgroundColor(Color.white);
        window.addShape(info);
    }


    /**
     * Updates the visual representation of the planets information
     * on the window. Displays planet name, population/capacity and
     * minimum required skills.
     * 
     * Each planet has a rectangular structure that
     * demonstrates population growth with a darker field rising from the
     * bottom. The color of the applicant and planet are matching if they
     * have requested to be admitted.
     * 
     * Note: For visual preference, I did not outline the planet shapes and
     * I did this on purpose. (setForegroundColor would be what I used.)
     */
    private void updateWindowPlanets() {
        // Clear window
        window.repaint();
        Planet[] planets = ColonyCalculator.getPlanets();

        // Coordinate and size temporary variables
        int offsetInfo_X = 80;
        int offsetInfo_Y = 58;
        int offsetSkill_Y = 40;
        int offsetYSquare = 190;
        int planetShapeSize = 90;

        // Temporary strings
        String planInfo = "";
        String skillInfo = "";

        // Shape objects and attributes temp vars
        Shape sq = null;
        Shape fill = null;
        Color fillColor;

        int height = 0;
        int size_sq = 0;
        int population = 0;

        AList<Shape> planetSquares = new AList<Shape>();

        TextShape[] shape = new TextShape[ColonyCalculator.NUM_PLANETS];
        TextShape[] skills = new TextShape[ColonyCalculator.NUM_PLANETS];

        for (int i = 0; i < shape.length; i++) {

            // Store planet and skill info as text shape objects
            planInfo = planets[i + 1].getName() + ", " + planets[i + 1]
                .getPopulationSize() + "/" + planets[i + 1].getCapacity();
            skillInfo = planets[i + 1].getSkills().toString();

            shape[i] = new TextShape(offsetInfo_X, window.getGraphPanelHeight()
                - offsetInfo_Y, planInfo);
            shape[i].setBackgroundColor(Color.WHITE);

            skills[i] = new TextShape(offsetInfo_X, window.getGraphPanelHeight()
                - offsetSkill_Y, skillInfo);
            skills[i].setBackgroundColor(Color.WHITE);

            // Create and store shape objects for squares and fillers
            fillColor = colors[i + 1].darker();
            height = window.getGraphPanelHeight() - offsetYSquare;
            size_sq = 130 - planets[i + 1].getPopulationSize() * 10;
            population = planets[i + 1].getPopulationSize() * 10;

            sq = new Shape(offsetInfo_X, height, planetShapeSize, size_sq,
                colors[i + 1]);

            height += sq.getHeight();

            fill = new Shape(offsetInfo_X, height, planetShapeSize, population,
                fillColor);

            planetSquares.add(sq);
            planetSquares.add(fill);

            offsetInfo_X += 150;
        }

        // Add info and skills to the window
        for (int i = 0; i < shape.length; i++) {
            window.addShape(shape[i]);
            window.addShape(skills[i]);
        }

        // Add shapes to the window
        for (int i = 0; i < shape.length * 2; i++) {
            window.addShape(planetSquares.getEntry(i));
        }

    }
}
