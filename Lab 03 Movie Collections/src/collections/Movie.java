package collections;

/**
 * MovieADT abstraction to represent a movie to be stored
 * in a movie collection. Each movie object has a title (string),
 * genre (string), rating (int), and year (int).
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 25, 2018
 */
public class Movie extends MovieADT {

    // ----------------------------------------------------------
    /**
     * Create a new Movie object.
     * 
     * @param title
     *            The name of the movie.
     */
    public Movie(String title) {
        super(title);
    }

}
