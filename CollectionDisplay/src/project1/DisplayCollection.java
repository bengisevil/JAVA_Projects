// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package project1;

import bag.Bag;
import bag.BagInterface;
import java.util.Random;

/**
 * DisplayCollection class contains the randomly generated bag.
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 30, 2018
 */
public class DisplayCollection {
    /**
     * STRINGS is an array of strings that belong to this class.
     * It cannot be modified.
     */
    public static final String[] STRINGS = new String[] { "red circle",
        "blue circle", "red square", "blue square" };

    private BagInterface<String> itemBag;


    // ----------------------------------------------------------
    /**
     * Create a new DisplayCollection object.
     */
    public DisplayCollection() {
        this.itemBag = new Bag<>();
        Random random = new Random();
        int size = random.nextInt(11) + 5;
        int index;
        for (int i = 0; i < size; i++) {
            index = random.nextInt(4);
            itemBag.add(STRINGS[index]);
        }
    }


    /**
     * Get itemBag field
     * 
     * @return The itemBag field
     */
    public BagInterface<String> getItemBag() {
        return itemBag;
    }

}
