/**
 * 
 */
package employees;

// -------------------------------------------------------------------------
/**
 * Represents an average employee working less than 40 hours per week.
 *
 * @author Bengi Sevil (bsevil18)
 * @version May 23, 2018
 */
public class ExternalContractor extends Employee {

    // ~ Constructor ...........................................................
    /**
     * New PartTimeEmployee object.
     *
     * @param name
     *            Name of Employee
     * @param hourlyRate
     *            Pay rate of Employee (per hour)
     */
    public ExternalContractor(String name, double hourlyRate) {
        super(name, hourlyRate);
    }

    // ~ Methods ...............................................................


    // ----------------------------------------------------------
    /**
     * Gets the external contractor's pay per hour based on customer rank.
     * 
     * @precondition customer rank must be a positive value.
     * @param custRank
     *            The customer's rank(1-3)
     * @return 38.50 if rate is 1, 41.
     */
    public double getHourlyRate(int custRank) {
        switch (custRank) {
            case 1:
                return 38.50;
            case 2:
                return 41.75;
            default:
                return 45.50;
        }

    }


    // ----------------------------------------------------------
    /**
     * Amount paid to the external contractor per week.
     * 
     * @precondition custRank
     * @param hours
     *            The number of hours worked per week.
     * @param custRank
     *            The customer's rank (1-3)
     * @return Weekly pay for external contractor per week.
     */
    public double weeklyPay(int hours, int custRank) {
        return (getHourlyRate(custRank) * hours);
    }

}
