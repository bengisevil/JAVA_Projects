// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

import student.TestCase;

/**
 * This class tests the methods in the Planet class.
 * 
 * @author Bengi Sevil
 * @version 06.19.2018
 *
 */
public class PlanetTest extends TestCase {
    private Planet planet1;


    /**
     * Instantiates a new Planet object.
     */
    public void setUp() {
        planet1 = new Planet("Nars", 2, 4, 4, 10);
    }


    /**
     * Tests for setName accurate results.
     */
    public void testSetName() {
        assertEquals("Nars", planet1.getName());
        planet1.setName("Mars");
        assertEquals("Mars", planet1.getName());
    }


    /**
     * Tests getName for accurate results.
     */
    public void testGetName() {
        assertEquals("Nars", planet1.getName());
    }


    /**
     * Tests getSkills for accurate results.
     */
    public void testGetSkills() {
        Skills skill = new Skills(2, 4, 4);
        assertEquals(skill, planet1.getSkills());
    }


    /**
     * Tests getPopulation for accurate results.
     */
    public void testGetPopulation() {
        Person[] person = new Person[planet1.getCapacity()];
        Person[] population = planet1.getPopulation();
        for (int i = 0; i < 10; i++) {
            assertEquals(person[i], population[i]);
        }
    }


    /**
     * Tests getPopulationSize for accurate results.
     */
    public void testGetPopulationSize() {
        assertEquals(0, planet1.getPopulationSize());
    }


    /**
     * Tests getCapacity for accurate results.
     */
    public void testGetCapacity() {
        assertEquals(10, planet1.getCapacity());
    }


    /**
     * Tests getAvailability for accurate results.
     */
    public void testGetAvailability() {
        assertEquals(10, planet1.getAvailability());
        Person person = new Person("jane", 3, 5, 4, "Nars");
        planet1.addPerson(person);
        assertEquals(9, planet1.getAvailability());
        for (int i = 0; i < 9; i++) {
            planet1.addPerson(person);
        }
        assertEquals(0, planet1.getAvailability());
    }


    /**
     * Tests isFull for accurate results.
     */
    public void testIsFull() {
        assertFalse(planet1.isFull());
        Person person = new Person("jane", 3, 5, 4, "Nars");
        for (int i = 0; i < 10; i++) {
            planet1.addPerson(person);
        }
        assertTrue(planet1.isFull());

    }


    /**
     * Tests addPerson for accurate results.
     */
    public void testAddPerson() {
        Person person = new Person("jane", 3, 5, 4, "Nars");
        Person notQualified = new Person("jane", 1, 1, 1, "Nars");
        assertTrue(planet1.addPerson(person));
        assertTrue(planet1.addPerson(person));
        assertEquals(2, planet1.getPopulationSize());
        assertFalse(planet1.addPerson(notQualified));
        // Add to full planet
        for (int i = 0; i < 8; i++) {
            planet1.addPerson(person);
        }
        assertTrue(planet1.isFull());
        assertFalse(planet1.addPerson(person));
    }


    /**
     * Tests isQualified for accurate results.
     */
    public void testIsQualified() {
        Person person = new Person("jane", 3, 5, 4, "Nars");
        Person notQualified1 = new Person("jane", 1, 1, 1, "Nars");
        Person notQualified2 = new Person("jane", 1, 5, 1, "Nars");
        Person notQualified3 = new Person("jane", 1, 1, 5, "Nars");
        Person notQualified4 = new Person("jane", 5, 1, 1, "Nars");

        assertTrue(planet1.isQualified(person));
        assertFalse(planet1.isQualified(notQualified1));
        assertFalse(planet1.isQualified(notQualified2));
        assertFalse(planet1.isQualified(notQualified3));
        assertFalse(planet1.isQualified(notQualified4));
    }


    /**
     * Tests compareTo for accurateResults.
     */
    public void testCompareTo() {
        Planet planet2 = new Planet("Mars", 2, 3, 2, 20);
        Person person = new Person("jane", 3, 5, 4, "Nars");
        assertTrue(planet1.addPerson(person));
        assertTrue(planet2.addPerson(person));
        assertEquals(-10, planet1.compareTo(planet2));
    }


    /**
     * Tests equals method for accurate results.
     */
    public void testEquals() {
        Planet same = new Planet("Nars", 2, 4, 4, 10);
        Planet different1 = new Planet("Nars", 1, 1, 1, 10);
        Planet different2 = new Planet("Mars", 2, 4, 4, 10);
        Planet different3 = new Planet("Nars", 2, 4, 4, 20);
        Planet different4 = new Planet("Nars", 2, 1, 1, 10);
        Planet different5 = new Planet("Nars", 2, 4, 4, 10);
        Planet nullP = null;

        assertTrue(planet1.equals(planet1));
        assertTrue(planet1.equals(same));

        assertFalse(planet1.equals(nullP));
        assertFalse(planet1.equals(different1));
        assertFalse(planet1.equals(different2));
        assertFalse(planet1.equals(different3));
        assertFalse(planet1.equals(different4));
        assertFalse(planet1.equals("a"));

        Person person1 = new Person("a", 5, 5, 5, "Nars");
        Person person2 = new Person("b", 5, 5, 5, "");
        planet1.addPerson(person1);
        different5.addPerson(person2);
        assertFalse(planet1.equals(different5));

        Planet same1 = new Planet("Nars", 2, 4, 4, 10);
        same1.addPerson(person1);
        assertTrue(planet1.equals(same1));

        same1.addPerson(person1);
        assertFalse(planet1.equals(same1));
    }


    /**
     * Tests toString for accurate results.
     */
    public void testToString() {
        String compare =
            "Nars, population 0 (cap: 10), Requires: A >= 2, M >= 4, T >= 4";
        assertEquals(compare, planet1.toString());
        Planet different1 = new Planet("Nars", 1, 1, 1, 10);
        compare =
            "Nars, population 0 (cap: 10), Requires: A >= 1, M >= 1, T >= 1";
        assertEquals(compare, different1.toString());
    }

}
