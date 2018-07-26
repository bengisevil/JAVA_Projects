// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package towerofhanoi;

import java.awt.Color;
import CS2114.Shape;
import student.TestableRandom;

/**
 * The Disc class represents the discs that are being moved
 * from one tower to another in the Towers of Hanoi game. It extends
 * the class shape as the disc is represented as rectangles of
 * various widths.
 * 
 * @author Bengi Sevil
 * @version 06.12.2018
 */
public class Disc extends Shape implements Comparable<Disc> {
    /**
     * Default constructor of Disc class. Creates a new Disc
     * object. Invokes the default constructor of shape with
     * the parameter width.
     * 
     * @param width
     *            The width of the disc.
     */
    public Disc(int width) {
        super(175, 150, width, GameWindow.DISC_HEIGHT);
        TestableRandom ran = new TestableRandom();
        Color color = new Color(ran.nextInt(256), ran.nextInt(256), ran.nextInt(
            256));
        super.setBackgroundColor(color);
    }


    /**
     * Current disc is compared to other disc to determine
     * relative sizes of the discs. If other disc is null, throws
     * an exception.
     * 
     * @throws IllegalArgumentException
     * @param otherDisc
     *            The other disc being compared to the current disc.
     * @return -1 if disc is smaller than otherDisc
     *         0 if disc and otherDisc are of same size
     *         1 if disc is larger than otherDisc
     */
    public int compareTo(Disc otherDisc) {
        if (otherDisc == null) {
            throw new IllegalArgumentException();
        }

        if (this.getWidth() < otherDisc.getWidth()) {
            return -1;
        }
        else if (this.getWidth() > otherDisc.getWidth()) {
            return 1;
        }
        else {
            return 0;
        }
    }


    /**
     * Returns the string representation of the width of
     * the disc.
     * 
     * @return string representation of width.
     */
    public String toString() {
        int width = this.getWidth();
        return Integer.toString(width);
    }


    /**
     * Equals method for the Disc class. Two discs are considered
     * equal if they have the same width value.
     * 
     * @param obj
     *            The object being checked against.
     * 
     * @return {@code true} if two discs have the same width
     *         {@code false} otherwise
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Disc other = (Disc)obj;
        return (this.getWidth() == other.getWidth());
    }

}
