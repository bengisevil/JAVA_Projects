package groceries;

// -------------------------------------------------------------------------
/**
 * The Grocery Bag class is a bag data structure that holds String objects
 * that represent grocery store items.
 *
 * @author Megan Rigsbee (mrigsbee)
 * @version 2015.04.25
 * @author Grace Fields
 * @version 2016.02.01
 * @author Bengi Sevil (bsevil18)
 * @version 2018.05.30
 */
public class GroceryBag extends ArrayBasedBag {
    // Constructors ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates an empty bag using the default capacity.
     */
    public GroceryBag() {
        super(10);
    }


    // Public methods ........................................................
    /**
     * If an element is in both bags, then it will be in the
     * intersection. If there are multiple occurrences of that
     * element, then the number of occurrences of that element
     * in the intersection will equal the minimum number of occurrences
     * in either set.
     * 
     * Examples:
     * intersection of
     * ({"apple","apple","cereal","chips"},
     * {"chips", "apple","apple","chips","cake"})
     * = {"apple","apple","chips"}
     * 
     * @param bag
     *            Bag to be intersected with.
     * @return The intersection of the two bags.
     */
    public GroceryBag intersection(GroceryBag bag) {
        String[] thisContents = this.contents();
        String[] otherContents = bag.contents();
        GroceryBag intersect = new GroceryBag();

        for (int i = 0; i < thisContents.length; i++) {
            for (int j = 0; j < otherContents.length; j++) {
                if (thisContents[i] != null && thisContents[i].equals(
                    otherContents[j])) {
                    intersect.add(thisContents[i]);
                    otherContents[j] = null;
                    thisContents[i] = null;
                }
            }
        }
        return intersect;
    }


    /**
     * For two bags to be equal they need to contain items
     * with the exact same value (but not the same item, so
     * equality not identity). Order does not matter, but
     * number of occurrences does.
     * 
     * @param givenBag
     *            Other GroceryBag to be compared with for equality.
     * @return Returns true if the two bags have the same items.
     */
    @Override
    public boolean equals(Object givenBag) {
        if (this == givenBag) {
            return true;
        }
        if (givenBag == null) {
            return false;
        }
        if (this.getClass() != givenBag.getClass()) {
            return false;
        }

        GroceryBag other = (GroceryBag)givenBag;
        String[] contents1 = this.contents();
        String[] contents2 = other.contents();

        if (this.size() == other.size()) {
            for (int i = 0; i < contents1.length; i++) {
                if ((contents1[i] != null) && (!other.contains(contents1[i]))) {
                    return false;
                }
            }

            return true;
        }
        return false;
    }

}
