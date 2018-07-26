// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

import student.TestCase;

/**
 * This class tests the methods in the Person class.
 * 
 * @author Bengi Sevil
 * @version 06.19.2018
 *
 */
public class PersonTest extends TestCase {
    private Person person1;
    private Person person2;


    /**
     * Creates person objects.
     */
    public void setUp() {
        person1 = new Person("Jane Doe", 2, 3, 4, "Nars");
        person2 = new Person("Ellie Gold", 1, 2, 3, "");
    }


    /**
     * Tests getName method for accurate results.
     */
    public void testGetName() {
        assertEquals("Jane Doe", person1.getName());
    }


    /**
     * Tests getSkills method for accurate results.
     */
    public void testGetSkills() {
        Skills temp = new Skills(2, 3, 4);
        assertEquals(temp, person1.getSkills());
    }


    /**
     * Tests getPlanetName for accurate results.
     */
    public void testGetPlanetName() {
        assertEquals("Nars", person1.getPlanetName());
    }


    /**
     * Tests toString method for accurate results.
     */
    public void testToString() {
        assertEquals("Jane Doe A:2 M:3 T:4 Wants: Nars", person1.toString());
        assertEquals("No-Planet Ellie Gold A:1 M:2 T:3", person2.toString());
    }


    /**
     * Tests the equals method for accurate results.
     */
    public void testEquals() {
        Person temp1 = new Person("Jane Doe", 2, 3, 4, "Nars");
        Person temp2 = new Person("James", 2, 3, 4, "Nars");
        Person temp3 = new Person("Jane Doe", 2, 5, 4, "Nars");
        Person temp4 = new Person("Jane Doe", 2, 3, 4, "Mars");
        Person np = null;
        assertFalse(person1.equals(np));
        assertTrue(person1.equals(person1));
        assertFalse(person1.equals("a"));
        assertTrue(person1.equals(temp1));
        assertFalse(person1.equals(temp2));
        assertFalse(person1.equals(temp3));
        assertFalse(person1.equals(temp4));
        assertFalse(person1.equals(person2));

    }

}
