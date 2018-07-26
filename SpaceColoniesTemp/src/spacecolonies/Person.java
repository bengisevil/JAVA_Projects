// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

/**
 * These objects contain a string, for a person’s name,
 * a skills object, and a String representation of their
 * planet preference.
 * 
 * @author Bengi Sevil
 * @version 06.20.2018
 *
 */
public class Person {
    private String name;
    private Skills skills;
    private String planetPreference;


    /**
     * Creates a new person of this.name name, with skill values of
     * agri for agriculture, medi for medicine, tech for technology
     * and with planetPreference of planet.
     * 
     * @param name
     *            Name of the person.
     * @param agri
     *            Agriculture skill. Must be between 1-5.
     * @param medi
     *            Medicine skill. Must be between 1-5.
     * @param tech
     *            Technology skill. Must be between 1-5.
     * @param planet
     *            Planet preference.
     */
    public Person(String name, int agri, int medi, int tech, String planet) {
        this.name = name;
        skills = new Skills(agri, medi, tech);
        planetPreference = planet;
    }


    /**
     * Returns the name of the person.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the skills set of the person.
     * 
     * @return skills
     */
    public Skills getSkills() {
        return skills;
    }


    /**
     * Returns the planet preference of the person.
     * 
     * @return planetPreference
     */
    public String getPlanetName() {
        return planetPreference;
    }


    /**
     * String representation of the person information.
     * 
     * @return string representation of Person info.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name);
        builder.append(" " + skills.toString());
        if (planetPreference.length() > 0) {
            builder.append(" Wants: " + planetPreference);
        }
        else {
            return ("No-Planet " + builder.toString());
        }
        return builder.toString();
    }


    /**
     * Two Person objects are considered equal when their name,
     * skills, and planet preference value is the same.
     * 
     * @return {@code true} if two people are equal.
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
        Person other = (Person)obj;
        return (this.name == other.name && this.getSkills().equals(other
            .getSkills()) && this.getPlanetName() == other.getPlanetName());
    }
}
