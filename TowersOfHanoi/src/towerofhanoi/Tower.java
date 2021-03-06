// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)

package towerofhanoi;

/**
 * Tower class represents the poles in the TowersOfHanoi game.
 * This class extends the LinkedStack class of type Disc since
 * it will contain discs for the game.
 * 
 * @author Bengi Sevil
 * @version 06.14.2018
 *
 */
public class Tower extends LinkedStack<Disc> {
    private Position position;


    /**
     * Default constructor for Tower class. Creates a new
     * object of type Tower. Calls the super constructor
     * with to create the linked stack and initializes
     * position to newPosition.
     * 
     * @param position
     *            Identifies left, middle or right pole.
     */
    public Tower(Position position) {
        super();
        this.position = position;
    }


    /**
     * Returns the tower's position.
     * 
     * @return position of the tower.
     */
    public Position position() {
        return position;
    }


    /**
     * Adds a new disc on the pole. Checks the size of the
     * existing disc if not empty, and adds only if the size
     * of the new disc is smaller.
     * 
     * @throws IllegalArgumentException
     *             if disc is null.
     * @throws IllegalStateException
     *             if disc is not smaller than top disc.
     * @param disc
     *            The new disc to be added.
     */
    @Override
    public void push(Disc disc) {
        if (disc == null) {
            throw new IllegalArgumentException();
        }
        if (isEmpty() || disc.compareTo(peek()) == -1) {
            super.push(disc);
        }
        else if (disc.compareTo(peek()) == 0) {
            throw new IllegalStateException();
        }
        else {
            throw new IllegalStateException();
        }

    }

}
