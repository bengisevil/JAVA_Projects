// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

import student.TestCase;

/**
 * This class tests the methods in the ColonyCalculator class.
 * 
 * @author Bengi Sevil
 * @version 06.19.2018
 *
 */
public class ColonyCalculatorTest extends TestCase {
    private ColonyCalculator test1;
    private ArrayQueue<Person> queue;
    private Planet[] planets;
    private Person person1;
    private Person person2;
    private Planet planet1;
    private Planet planet2;
    private Planet planet3;


    /**
     * Instantiates a new ColonyCalculator object with
     * various members and qualities.
     */
    public void setUp() {
        person1 = new Person("Jane Doe", 1, 3, 4, "Nars");
        person2 = new Person("James Dough", 2, 5, 4, "Nars");

        queue = new ArrayQueue<Person>();
        queue.enqueue(person1);
        queue.enqueue(person2);
        planets = new Planet[ColonyCalculator.NUM_PLANETS + 1];
        planet1 = new Planet("Nars", 2, 4, 4, 10);
        planet2 = new Planet("Mars", 3, 4, 4, 20);
        planet3 = new Planet("WowzyPlanet", 2, 2, 2, 10);
        planets[1] = planet1;
        planets[2] = planet2;
        planets[3] = planet3;

        test1 = new ColonyCalculator(queue, planets);
    }


    /**
     * Test EmptyQueueException being thrown in the constructor.
     */
    public void testConstructor() {
        planets = new Planet[ColonyCalculator.NUM_PLANETS + 1];

        planets[1] = planet1;
        planets[2] = planet2;
        planets[3] = planet3;

        ArrayQueue<Person> nullQ = null;
        Exception exception = null;
        try {
            test1 = new ColonyCalculator(nullQ, planets);
        }
        catch (Exception e) {
            exception = e;
        }
        assertNotNull(exception);
    }


    /**
     * Tests getQueue for accurate results.
     */
    public void testGetQueue() {
        ArrayQueue<Person> testQ = new ArrayQueue<Person>();
        testQ.enqueue(person1);
        testQ.enqueue(person2);

        assertTrue(testQ.equals(test1.getQueue()));
    }


    /**
     * Tests getPlanets method for accurate results.
     */
    public void testGetPlanets() {
        Planet[] plts = new Planet[4];
        plts[1] = planet1;
        plts[2] = planet2;
        plts[3] = planet3;
        Planet[] getPlanets = ColonyCalculator.getPlanets();
        assertEquals(null, getPlanets[0]);
        for (int i = 1; i < 4; i++) {
            assertTrue(plts[i].equals(getPlanets[i]));
        }
    }


    /**
     * Tests getPlanetForPerson for accurate resutls.
     */
    public void testGetPlanetForPerson() {
        Person nullp = null;
        Person noSuchPlanet = new Person("a", 5, 5, 5, "slay");
        assertEquals(planet1, test1.getPlanetForPerson(person2));
        assertEquals(null, test1.getPlanetForPerson(person1));
        assertEquals(null, test1.getPlanetForPerson(nullp));
        assertEquals(planet2, test1.getPlanetForPerson(noSuchPlanet));
        
    }


    /**
     * Tests accept method for accurate results.
     */
    public void testAccept() {
        ArrayQueue<Person> emptyQueue = new ArrayQueue<Person>();
        planets[1] = planet1;
        planets[2] = planet2;
        planets[3] = planet3;

        ColonyCalculator test2 = new ColonyCalculator(emptyQueue, planets);
        assertFalse(test2.accept());
        assertFalse(test1.accept());
        test1.reject();
        assertTrue(test1.accept());

        for (int i = 0; i < 12; i++) {
            queue.enqueue(person2);
        }
        test1 = new ColonyCalculator(queue, planets);
        for (int i = 0; i < 9; i++) {
            assertTrue(test1.accept());
        }

        assertFalse(test1.accept());

        Person p1 = new Person("James Dough", 2, 5, 4, "WowzyPlanet");
        Person p2 = new Person("James Dough", 5, 5, 4, "Mars");

        queue.clear();
        for (int i = 0; i < 12; i++) {
            queue.enqueue(p1);
        }
        for (int i = 0; i < 22; i++) {
            queue.enqueue(p2);
        }
        test1 = new ColonyCalculator(queue, planets);

        for (int i = 0; i < 10; i++) {
            assertTrue(test1.accept());
        }
        assertFalse(test1.accept());
        test1.reject();
        assertFalse(test1.accept());
        test1.reject();

        for (int i = 0; i < 10; i++) {
            assertTrue(test1.accept());
            assertTrue(test1.accept());
        }

        assertFalse(test1.accept());
        test1.reject();
        assertFalse(test1.accept());
        test1.reject();

        p2 = new Person("a", 5, 5, 5, "");
        queue.enqueue(p2);
        assertFalse(test1.accept());
        test1.reject();

        p2 = new Person("a", 5, 5, 5, "");
        p1 = new Person("a", 1, 1, 1, "");
        Planet planetX = new Planet("Glee", 3, 3, 3, 10);
        Planet planetY = new Planet("Slayzy", 3, 3, 3, 5);
        planets[1] = planetX;
        planets[2] = planetY;
        queue.enqueue(p2);
        queue.enqueue(p1);
        assertEquals(planetX, test1.getPlanetForPerson(p2));
        assertTrue(test1.accept());
        assertFalse(test1.accept());

    }


    /**
     * Tests reject method for accurate results.
     */
    public void testReject() {
        assertEquals(person1, queue.getFront());
        test1.reject();
        assertEquals(person2, queue.getFront());

    }


    /**
     * Tests planetByNumber for accurate results.
     */
    public void testPlanetByNumber() {
        assertEquals(planet1, test1.planetByNumber(1));
        assertEquals(null, test1.planetByNumber(0));
        assertEquals(planet2, test1.planetByNumber(2));
        assertEquals(null, test1.planetByNumber(4));
    }


    /**
     * Tests getPlanetIndex for accurate results.
     */
    public void testGetPlanetIndex() {
        assertEquals(0, test1.getPlanetIndex("Blah"));
        assertEquals(1, test1.getPlanetIndex("Nars"));
    }
}
