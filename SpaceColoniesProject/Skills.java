// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

/**
 * These objects contain three ints for their
 * skills(on a scale of 1 to 5).
 * 
 * @author Bengi Sevil
 * @version 06.19.2018
 */
public class Skills {
    private int agriculture;
    private int medicine;
    private int technology;


    /**
     * Default constructor for the Skills class. Creates
     * a new Skills object and initializes the private fields
     * to the ones given as the parameters.
     * 
     * @precondition ag, med and tech must be an integer between
     *               1-5 inclusively.
     * 
     * @param ag
     *            The agriculture skill on a scale of 1-5.
     * @param med
     *            The medicine skill on a scale of 1-5.
     * @param tech
     *            The technology skill on a scale of 1-5.
     */
    public Skills(int ag, int med, int tech) {
        agriculture = ag;
        medicine = med;
        technology = tech;
    }


    /**
     * Returns the agriculture skill.
     * 
     * @return agriculture
     */
    public int getAgriculture() {
        return agriculture;
    }


    /**
     * Returns the medicine skill.
     * 
     * @return medicine
     */
    public int getMedicine() {
        return medicine;
    }


    /**
     * Returns the technology skill.
     * 
     * @return technology
     */
    public int getTechnology() {
        return technology;
    }


    /**
     * Compare a given Skill "other" to "this" Skill.
     * 
     * @param other
     *            The skills object being compared.
     * @return {@code true} if "this.agriculture" is less
     *         or equal to "other.agriculture" AND "this.medicine"
     *         is less or equal to "other.medicine" AND "this.technology"
     *         is less or equal to "other.technology".
     *         {@code false} otherwise.
     */
    public boolean isBelow(Skills other) {
        return (this.agriculture <= other.agriculture
            && this.medicine <= other.medicine
            && this.technology <= other.technology);
    }


    /**
     * Returns the string representation of the skills.
     * 
     * @return string representation of skills.
     */
    public String toString() {
        return ("A:" + Integer.toString(getAgriculture()) + " M:" + Integer
            .toString(getMedicine()) + " T:" + Integer.toString(
                getTechnology()));
    }


    /**
     * Two Skills objects are equal if all three fields,
     * agriculture, medicine, and technology, are equal.
     * 
     * @param obj
     *            The object being checked agains the current skills object.
     * 
     * @return {@code true} if all three fields of other is equal to those of
     *         this.
     *         {@code false} otherwise.
     */
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Skills other = (Skills)obj;
        return (this.agriculture == other.agriculture
            && this.medicine == other.medicine
            && this.technology == other.technology);
    }
}
