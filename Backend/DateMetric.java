/*
 * DateMetric.java
 * 
 * Represents a metric involving a date. For example, a goal to finish a project by a certain date.
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

import java.util.Date;

public class DateMetric extends Metric<Date> {
    /**
     * constructor
     * 
     * @param aName - name of metric
     * @param aValue - current value of metric
     * @param aTarget - target value of metric
     */
    public DateMetric(String aName, Date aValue, Date aTarget) {
        super(aName, aValue, aTarget);
    }
}