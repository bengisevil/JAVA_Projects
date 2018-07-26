/**
 * 
 */
package people;

import java.util.Calendar;

/**
 * A person who considers him/herself a Hokie
 * 
 * @author maellis1
 * @version 06.03.2015
 *
 */
public class Hokie {
    private String pid;
    private String hometown;
    private int graduationYear;
    
    
    /** Constructor
     * @param pid personal id associated with Virginia Tech
     */
    public Hokie(String pid){
        this.pid = pid;
    }

    /** Constructor
     * @param pid personal id associated with Virginia Tech
     * @param graduationYear
     */
    public Hokie(String pid, int gradYear){
        this.pid = pid;
        this.graduationYear = gradYear;
    }
    
    /**
     * setter for graduation year
     * @param gradYear
     */  
    public void setGradYear(int gradYear){
        this.graduationYear = gradYear;
    }
    
    /**
     * setter for hometown
     * @param hometown
     */  
    public void setHometown(String hometown){
        this.hometown = hometown;
    }
    
    /**
     * getter for graduation year
     * @return year of graduation
     */
    public int getGradYear(){
        return graduationYear;
    }
    
    /**
     * getter for pid
     * @return pid
     */
    public String getPID(){
        return pid;
    }
    
    
    /**
     * getter for hometown
     * @return hometown
     */
    public String getHometown(){
        return hometown;
    }
    
    
    /**
     * Determines next Reunion year based on reunions every 5 years
     * @return year of next Reunion
     */ 
    public int nextReunion(){
        int currYear;
        currYear = Calendar.getInstance().get(Calendar.YEAR);
        //use modulo
        int yearDiff = currYear - graduationYear;
        if (yearDiff <= 0)
            return currYear + (5 - yearDiff);
        else return currYear + (5 - (yearDiff % 5) );
        //use a loop
        //int checkYear = graduationYear + 5;
        //while (checkYear < currYear)
        //     checkYear += 5;
        //return checkYear;
                
    }
    
    
    /**
     * one class in a program can have a main method
     * it is the entry point for a program if it is run as an application
     * 
     * @param args
     */
    public static void main(String[] args) {
        Hokie ellis = new Hokie("maellis1", 2002);
        int saveTheDate = ellis.nextReunion();
        System.out.println("Be in Blacksburg, Homecoming " + saveTheDate + "!");
    }
}
   

 
    
    
    

