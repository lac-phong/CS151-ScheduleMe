/*
 * IntegerMetric.java
 * 
 * Represents a metric having an integer value. For example, a goal of exercising 5 times per week.
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

public class IntegerMetric extends Metric<Integer> {
/**
     * constructor
     * 
     * @param aName - name of metric
     * @param aValue - current value of metric
     * @param aTarget - target value of metric
     */
    public IntegerMetric(String aName, Integer aValue, Integer aTarget) {
        super(aName, aValue, aTarget);
    }
}