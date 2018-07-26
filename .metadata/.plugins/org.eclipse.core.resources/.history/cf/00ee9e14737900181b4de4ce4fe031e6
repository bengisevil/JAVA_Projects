// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * The ColonyReader parses the input data from two text files.
 * It generates the planets and queue of applicants based on one file of
 * comma separated values about applicants and the other about each
 * planet. Then it gives SpaceWindow this queue in order to tie everything
 * together.
 * 
 * @author Bengi Sevil
 * @version 06.21.2018
 *
 */
public class ColonyReader {
    private Planet[] planets;
    private ArrayQueue<Person> queue;


    /**
     * Creates a new ColonyReader object, reads from the
     * applicantFileName and planetFileName and stores the
     * contents. It uses the member methods readQueueFile and
     * readPlanetFile.
     * 
     * @param applicantFileName
     *            File that contains applicant information.
     * @param planetFileName
     *            File that contains planet inforamtion.
     * @throws ParseException
     * @throws SpaceColonyDataException
     * @throws FileNotFoundException
     */
    public ColonyReader(String applicantFileName, String planetFileName)
        throws SpaceColonyDataException,
        ParseException, FileNotFoundException {
        queue = readQueueFile(applicantFileName);
        planets = readPlanetFile(planetFileName);
    }


    /**
     * Reads the contents of the file and stores the
     * planets in sequential order.
     * 
     * @param fileName
     *            The file to be read from.
     * @return the array of planets.
     * 
     * @throws ParseException
     *             if there aren't 5 inputs on each line.
     * @throws FileNotFoundException
     * 
     * @throws SpaceColonyException
     *             if skills are not between 1 and 5
     *             if there are less than 3 planets.
     */
    private Planet[] readPlanetFile(String fileName)
        throws SpaceColonyDataException,
        ParseException,
        FileNotFoundException {
        Planet[] arr = new Planet[3];
        File file = new File(fileName);
        Scanner myFile = new Scanner(file);
        String[] lineContents;
        String name = "";
        int ag = 0;
        int med = 0;
        int tech = 0;
        int cap = 0;
        Planet planet;
        int line = 0;
        while (myFile.hasNextLine() && line < 3) {

            lineContents = myFile.nextLine().split(", *");
            if (lineContents.length != 5) {
                throw new ParseException("Incorrect number of arguments.",
                    line);
            }
            if (isInSkillRange(Integer.valueOf(lineContents[1]), Integer
                .valueOf(lineContents[2]), Integer.valueOf(lineContents[3]))) {
                throw new SpaceColonyDataException(
                    "Minimum required skills must be between 1-5.");
            }

            // File is properly formatted
            Planet newPlanet = new Planet(lineContents[0], Integer.valueOf(
                lineContents[1]), Integer.valueOf(lineContents[2]), Integer
                    .valueOf(lineContents[3]), Integer.valueOf(
                        lineContents[4]));
            arr[line] = newPlanet;
            line++;
        }
        if (line != 3) {
            throw new SpaceColonyDataException(
                "There are less than 3 planets provided.");
        }
        return arr;
    }


    /**
     * Store the applicant information in the fileName into the array
     * queue of type Person.
     * 
     * @param fileName
     *            The applicant input file.
     * @return
     *         The ArrayQueue queue of type Person.
     * 
     * @throws SpaceColonyDataException
     *             if skills aren't between 1-5.
     * @throws ParseException
     *             if incorrect number of arguments are present.
     * @throws FileNotFoundException
     */
    private ArrayQueue<Person> readQueueFile(String fileName)
        throws SpaceColonyDataException,
        ParseException,
        FileNotFoundException {
        ArrayQueue<Person> queue = new ArrayQueue<Person>();
        File file = new File(fileName);
        Scanner myFile = new Scanner(file);
        String[] lineContents;
        int line = 0;
        while (myFile.hasNextLine()) {

            lineContents = myFile.nextLine().split(", *");
            if (lineContents.length > 5) {
                throw new ParseException("Incorrect number of arguments.",
                    line);
            }
            if (isInSkillRange(Integer.valueOf(lineContents[1]), Integer
                .valueOf(lineContents[2]), Integer.valueOf(lineContents[3]))) {
                throw new SpaceColonyDataException(
                    "Minimum required skills must be between 1-5.");
            }

            // File is properly formatted
            Person newPerson = new Person(lineContents[0], Integer.valueOf(
                lineContents[1]), Integer.valueOf(lineContents[2]), Integer
                    .valueOf(lineContents[3]), lineContents[4]);
            queue.enqueue(newPerson);
            line++;
        }

        return queue;

    }


    /**
     * Checks if ag, med and tech skills are between the given maximum and
     * minimum skill values, inclusively.
     * 
     * @param ag
     *            agriculture skill
     * @param med
     *            medicine skill
     * @param tech
     *            technology skill
     * @return {@code true} if skills are correctly formatted.
     *         {@code false} otherwise.
     */
    private boolean isInSkillRange(int ag, int med, int tech) {
        return ((ag <= ColonyCalculator.MAX_SKILL_LEVEL
            && ag >= ColonyCalculator.MIN_SKILL_LEVEL)
            && (med <= ColonyCalculator.MAX_SKILL_LEVEL
                && med >= ColonyCalculator.MIN_SKILL_LEVEL)
            && (tech <= ColonyCalculator.MAX_SKILL_LEVEL
                && tech >= ColonyCalculator.MIN_SKILL_LEVEL));
    }

}
