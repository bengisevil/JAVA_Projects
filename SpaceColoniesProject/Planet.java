// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

/**
 * These objects contain a string, for the planet’s name, three ints for their
 * minimum skill requirements (on a scale of 1 to 5), an array of Person objects
 * for current planet population, an int for storing the current population
 * size, and a final int for the maximum allowed capacity of the planet.
 * 
 * @author Bengi Sevil
 * @version 06.20.2018
 *
 */
public class Planet implements Comparable<Planet> {
    private String name;
    private Skills minSkills;
    private Person[] population;
    private int populationSize;
    private final int capacity;


    /**
     * Creates a new Planet object. Initializes all private fields.
     * 
     * @param planetName
     *            Name of the planet.
     * @param planetAgri
     *            Agriculture skill. Must be between 1-5.
     * @param planetMedi
     *            Medical skill. Must be between 1-5.
     * @param planetTech
     *            Technology skill. Must be between 1-5.
     * @param planetCap
     *            The capacity of the planet.
     */
    public Planet(
        String planetName,
        int planetAgri,
        int planetMedi,
        int planetTech,
        int planetCap) {

        name = planetName;
        minSkills = new Skills(planetAgri, planetMedi, planetTech);
        capacity = planetCap;
        populationSize = 0;
        population = new Person[capacity];
    }


    /**
     * Sets the name of the planet.
     * 
     * @param newName
     *            New name for the planet.
     */
    public void setName(String newName) {
        name = newName;
    }


    /**
     * Returns the name of the planet.
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Returns the minimum required skills of the planet.
     * 
     * @return minSkills
     */
    public Skills getSkills() {
        return minSkills;
    }


    /**
     * Returns the population of the planet.
     * 
     * @return population
     */
    public Person[] getPopulation() {
        return population;
    }


    /**
     * Returns the current population size of the planet.
     * 
     * @return populationSize.
     */
    public int getPopulationSize() {
        return populationSize;
    }


    /**
     * Returns the capacity of the planet.
     * 
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }


    /**
     * Returns the number of available places left in the planet.
     * 
     * @return number of spaces left.
     */
    public int getAvailability() {
        return (capacity - populationSize);
    }


    /**
     * Checks if the planet is full.
     * 
     * @return {@code true} if population size has reached capacity.
     *         {@code false} otherwise.
     */
    public boolean isFull() {
        return (populationSize == capacity);
    }


    /**
     * Attempts to add a new Person to the planet. Checks if there is
     * space and if the applicant is qualified. Returns true upon success.
     * 
     * @param newbie
     *            New applicant.
     * @return {@code true} if addition was succesful.
     *         {@code false} otherwise.
     */
    public boolean addPerson(Person newbie) {
        if (isFull()) {
            return false;
        }
        if (isQualified(newbie)) {
            population[populationSize] = newbie;
            populationSize++;
            return true;
        }
        return false;
    }


    /**
     * Checks whether applicant is qualified to be on this planet based
     * on their skills meeting the minimum requirement.
     * 
     * @param applicant
     *            New applicant to be considered.
     * @return {@code true} if the applicant was qualified.
     *         {@code false} otherwise.
     */
    public boolean isQualified(Person applicant) {
        return (minSkills.isBelow(applicant.getSkills()));
    }


    /**
     * Returns the string representation of the planet information.
     * Example output: "Caturn, population 5 (cap: 10), Requires: A >= 3, M >=
     * 2, T >= 1"
     * 
     * @return string representation of planet.
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(name + ", ");
        builder.append("population " + populationSize + " (cap: " + capacity
            + "), ");
        builder.append("Requires: " + "A >= " + minSkills.getAgriculture()
            + ", M >= " + minSkills.getMedicine() + ", T >= " + minSkills
                .getTechnology());
        return builder.toString();
    }


    /**
     * Compares this planet to other planet based on availability.
     * 
     * @param other
     *            The other planet.
     * @return the difference between availability in both planets.
     *         Negative result means this is smaller (less availability)
     *         Positive result menas this is greater (more availability)
     *         0 results means they have the same availability
     */
    @Override
    public int compareTo(Planet other) {
        return (this.getAvailability() - other.getAvailability());
    }


    /**
     * Two planets are equal if all 5 their input fields are equal and
     * populationSize is equal.
     * 
     * @param obj
     *            The object being compared to.
     * 
     * @return {@code true} if they are equal.
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
        Planet other = (Planet)obj;
        if (this.name == other.name && this.minSkills.equals(other.minSkills)
            && this.capacity == other.capacity
            && this.populationSize == other.populationSize) {
            for (int i = 0; i < this.populationSize; i++) {
                if (!this.population[i].equals(other.population[i])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
