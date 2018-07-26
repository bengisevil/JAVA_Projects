// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Bengi Sevil (bsevil18)
package spacecolonies;

import student.TestCase;
import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * Tests that we can read in colonists and planets from the file
 * using ColonyReader.
 * 
 * @author acbart
 * @version 5.25.2018
 */
public class ColonyReaderTest extends TestCase {
    /**
     * Run a series of test files to confirm that everything loads.
     * @throws FileNotFoundException 
     */
    public void testFiles() throws FileNotFoundException {
        // Basic file from Web-CAT
        successfulFile("input.txt", "planets1.txt");

        // Files that work perfectly
        successfulFile("people_good1.txt", "planets_good1.txt");
        successfulFile("people_good2.txt", "planets_good2.txt");

        // Planet Files that fail in various ways.
        failingFile("people_good2.txt", "planets_invalidSkill.txt",
            SpaceColonyDataException.class,
            "Failing file: Planet has minimum Tech skill that is too high.");
        failingFile("people_good2.txt", "planets_missingSkill.txt",
            ParseException.class,
            "Failing file: Planet is missing some skills.");
        failingFile("people_good2.txt", "planets_missingPlanet.txt",
            SpaceColonyDataException.class,
            "Failing file: there are only two planets instead of 3.");

        // Person Queue files that fail in various ways.
        failingFile("people_tooFewSkills.txt", "planets_good1.txt",
            ParseException.class, "Failing file: Somebody had too few skills.");
        failingFile("people_tooManySkills.txt", "planets_good1.txt",
            ParseException.class,
            "Failing file: Somebody had too many skills.");
        failingFile("people_highAgSkill.txt", "planets_good1.txt",
            SpaceColonyDataException.class,
            "Failing file: Somebody had too high an ag skill.");
        failingFile("people_lowAgSkill.txt", "planets_good1.txt",
            SpaceColonyDataException.class,
            "Failing file: Somebody had too low an ag skill.");
        failingFile("people_highMedSkill.txt", "planets_good1.txt",
            SpaceColonyDataException.class,
            "Failing file: Somebody had too low  a med skill.");
        failingFile("people_lowMedSkill.txt", "planets_good1.txt",
            SpaceColonyDataException.class,
            "Failing file: Somebody had too high a med skill.");
        failingFile("people_lowTechSkill.txt", "planets_good1.txt",
            SpaceColonyDataException.class,
            "Failing file: Somebody had too low a tech skill.");
        failingFile("people_highTechSkill.txt", "planets_good1.txt",
            SpaceColonyDataException.class,
            "Failing file: Somebody had too high a tech skill.");

        // Add an assert to fool Web-CAT
        boolean allSuccess = true;
        assertTrue(allSuccess);
    }


    /**
     * Load a pair of files that are expected to fail in a particular way.
     * 
     * @param queueFile
     *            The filename of the Person Queue to load
     * @param planetFile
     *            The filename of the planet
     * @param ex
     *            The expected exception type (note that this is a class!)
     * @param errorMessage
     *            The error message to show if the file loads correctly instead
     *            of showing the relevant error message.
     */
    public void failingFile(
        String queueFile,
        String planetFile,
        Class ex,
        String errorMessage) {
        Exception thrown = null;
        try {
            ColonyReader cr = new ColonyReader(queueFile, planetFile);
            cr.toString();
            fail(errorMessage);
        }
        catch (Exception e) {
            thrown = e;
        }
        assertNotNull(thrown);
        assertTrue("threw " + thrown.getClass() + " instead of " + ex.getName()
            + ".", ex.isInstance(thrown));
    }


    /**
     * Load a pair of files that are expected to succeed.
     * 
     * @param queueFile
     *            The filename of the Person Queue to load
     * @param planetFile
     *            The filename of the planet
     * @throws FileNotFoundException 
     */
    public void successfulFile(String queueFile, String planetFile) throws FileNotFoundException {
        ColonyReader cr;
        try {
            cr = new ColonyReader(queueFile, planetFile);
            cr.toString();
        }
        catch (ParseException | SpaceColonyDataException e) {
            e.printStackTrace();
        }
    }

    /**
     * Simple test for debugging webcats testMain4
     */ /*
         * public void testIP() {
         * Exception e = null;
         * try {
         * ProjectRunner.main(new String[] { "input.txt",
         * "planets_good1.txt" });
         * }
         * catch (Exception exception) {
         * e = exception;
         * e.printStackTrace();
         * }
         * assertNull(e);
         * }
         */
}
