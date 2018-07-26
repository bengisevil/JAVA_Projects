// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package src;

import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * The ProjectRunner class begins the program by creating a ColonyReader and
 * telling it which file to look at.
 * 
 * @author Bengi Sevil
 * @version 06.20.2018
 *
 */
public class ProjectRunner {

    /**
     * The main method that runs the application. If two command arguments
     * are provided, then those input files are used.
     * Otherwise, "input.txt" and "planets.txt" are used by default.
     * 
     * @param args
     * @throws ParseException
     * @throws SpaceColonyDataException
     * @throws FileNotFoundException
     */
    public static void main(String[] args)
        throws FileNotFoundException,
        SpaceColonyDataException,
        ParseException {

        String file1 = "input.txt";
        String file2 = "planets.txt";
        if (args.length == 2) {
            file1 = args[0];
            file2 = args[1];
        }
        ColonyReader reader = new ColonyReader(file1, file2);
        ColonyCalculator calc = new ColonyCalculator(reader.queue,
            reader.planets);
        SpaceWindow window = new SpaceWindow(calc);
    }
}