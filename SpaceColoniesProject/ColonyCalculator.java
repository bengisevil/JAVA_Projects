// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

import java.util.Arrays;
import list.AList;

/**
 * This object handles all the major calculations and
 * decision-making for the program. It is in charge of
 * handling accept and reject instructions and checking that
 * all requirements for a person are met before they are added
 * to a planet. It works together with SpaceWindow.
 * 
 * @author Bengi Sevil
 * @version 06.20.2018
 *
 */
public class ColonyCalculator {
    /**
     * NUM_PLANETS represents the total number of planets
     * to in the planets array.
     */
    public static final int NUM_PLANETS = 3;
    /**
     * MIN_SKILL_LEVEL represents the minimum number of planets
     * any skill can have to be valid.
     */
    public static final int MIN_SKILL_LEVEL = 1;
    /**
     * MAX_SKILL_LEVEL represents the maximum number of planets
     * any skill can have to be valid.
     */
    public static final int MAX_SKILL_LEVEL = 5;

    private ArrayQueue<Person> applicantQueue;
    private AList<Person> rejectBus;
    private static Planet[] planets;


    /**
     * Creates a new object of type ColonyCalculator and initializes
     * the private variables applicantQueue and planets to the parameters
     * given. Also initializes rejectBust to be initally empty, and
     * the planets to a Planet[] array of size NUM_PLANETS.
     * 
     * @param applicantQueue
     *            the queue containing applicants
     * @param planets
     *            the planets of subject
     * 
     * @throws IllegalArgumentException
     *             if applicantQueue is null.
     */
    public ColonyCalculator(
        ArrayQueue<Person> applicantQueue,
        Planet[] planets) {

        if (applicantQueue == null) {
            throw new IllegalArgumentException();
        }

        this.applicantQueue = new ArrayQueue<Person>();
        this.applicantQueue = applicantQueue;

        this.planets = new Planet[NUM_PLANETS + 1];
        this.planets = planets;

        rejectBus = new AList<Person>();
    }


    /**
     * Returns the applicant queue field.
     * 
     * @return applicantQueue.
     */
    public ArrayQueue<Person> getQueue() {
        return applicantQueue;
    }


    /**
     * Returns the planets field.
     * 
     * @return planets array.
     */
    public static Planet[] getPlanets() {
        return planets;
    }


    /**
     * Determines if the next applicant can be accepted
     * to a planet. If their planet preference is valid,
     * they are attempted to be placed there. Otherwise,
     * they are placed to the most available planet.
     * 
     * @param nextPerson
     *            next applicant
     * @return the planet they were placed in.
     */
    public Planet getPlanetForPerson(Person nextPerson) {
        if (nextPerson == null) {
            return null;
        }
        int planetNumber = getPlanetIndex(nextPerson.getPlanetName());
        if (planetNumber != 0) {
            return getPreferredPlanet(nextPerson, planetNumber);
        }
        return getMostAvailablePlanet(nextPerson);

    }


    /**
     * Attempts to return the planet that person preferred
     * by the index given.
     * 
     * @param person
     *            Applicant to the planet.
     * @param planetWanted
     *            Index of the planet.
     * @return the planet person was placed in.
     */
    private Planet getPreferredPlanet(Person person, int planetWanted) {
        Planet planet = planetByNumber(planetWanted);
        if (!planet.isFull() && planet.isQualified(person)) {
            return planet;
        }
        return null;
    }


    /**
     * For a person without planet preference, if there is a
     * planet that is not full and they qualify they are placed into
     * the most available planet.
     * 
     * @param person
     *            The applicant
     * @return the planet they were placed in.
     */
    private Planet getMostAvailablePlanet(Person person) {
        Planet[] deepCopy = Arrays.copyOf(planets, planets.length);
        Arrays.sort(deepCopy, 1, deepCopy.length);

        for (int i = deepCopy.length - 1; i > 0; i--) {
            if (!deepCopy[i].isFull() && deepCopy[i].isQualified(person)) {
                return deepCopy[i];
            }
        }
        return null;
        
        
    }


    /**
     * Attempts to accept the next applicant if the queue is not empty.
     * 
     * @return {@code true} if the person was added successfully.
     *         {@code false} otherwise.
     */
    public boolean accept() {
        if (applicantQueue.isEmpty()) {
            return false;
        }
        boolean added = false;
        Person newApplicant = applicantQueue.getFront();
        Planet prefer = getPlanetForPerson(newApplicant);
        if (prefer != null) {
            prefer.addPerson(newApplicant);
            added = true;
            applicantQueue.dequeue();
        }
        return added;
    }


    /**
     * Adds next applicant to the reject bus for the skill
     * training school.
     */
    public void reject() {
        rejectBus.add(applicantQueue.dequeue());
    }


    /**
     * Returns the Planet object for the given number (1-NUM_PLANETS).
     * For any other number returns null.
     * 
     * @param num
     *            Planet number; Valid inputs are 1 to NUM_PLANETS.
     * @return
     *         The corresponding planet.
     */
    public Planet planetByNumber(int num) {
        if (num >= 1 && num <= NUM_PLANETS) {
            return planets[num];
        }
        return null;
    }


    /**
     * Return the index to the Planet name given by the param name.
     * Returns 0 if planet does not exist in the planets.
     * 
     * @param name
     *            Planet name.
     * @return
     *         Index of name in the planets array.
     */
    public int getPlanetIndex(String name) {
        for (int i = 1; i < planets.length; i++) {
            if (planets[i].getName().equals(name)) {
                return i;
            }
        }
        return 0;
    }

}
