package people;


/**
 * Test class for Hokie
 * 
 * @author maellis1
 * @version Jun 3, 2015
 *
 */
public class HokieTest extends student.TestCase {

    private Hokie john;
    private Hokie elena;
    
    /**
     * Sets up the test cases.
     */

    public void setUp() {
        john = new Hokie("jfreedman3");
        elena = new Hokie("ehackworth2", 2005);
    }

    
 // ----------------------------------------------------------
    /**
     * test getGradYear()
     */
    public void testGetGradYear()
    {
        assertEquals(elena.getGradYear(), (int) 2005);
    }
    
    // ----------------------------------------------------------
    /**
     * test getPID()
     * Why does this test fail?
     */
    public void testGetPID()
    {
        assertEquals("ehackworth",elena.getPID());
    }
    
    // ----------------------------------------------------------
    /**
     * test getHometown()
     */
    public void testGetHometown()
    {
        elena.setHometown("Fredricksburg");
        assertEquals("Fredricksburg",elena.getHometown());
    }
    
 // ----------------------------------------------------------
    /**
     * test setGradYear()
     */
    public void testSetGradYear()
    {
        john.setGradYear(2010);
        assertEquals( 2010, john.getGradYear());
    }

 // ----------------------------------------------------------
    /**
     * test setHometown()
     */
    public void testSetHometown()
    {
        john.setHometown("Arlington");
        assertEquals("Arlington", john.getHometown());
    }
    
 // ----------------------------------------------------------
    /**
     * test nextReunion()
     */
    public void testNextReunion()
    {
        assertEquals(2020, elena.nextReunion());
        john.setGradYear(1993);
        assertEquals(2018,john.nextReunion());
        Hokie youngin = new Hokie("kaitlin98",2019);
        Hokie millenium = new Hokie("brandon99",2020);
        Hokie boomer = new Hokie("edward55",1963);
        assertEquals(2024, youngin.nextReunion());
        assertEquals(2025, millenium.nextReunion());
        assertEquals(2018, boomer.nextReunion());
    }
    

}
