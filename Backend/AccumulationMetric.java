/*
 * AccumulationMetric.java
 * 
 * Represents a metric consisting of a group of other metrics.
 * For example, a goal to exercise 5 times per week might be made up of 5 individual metrics, one for each day of the week.
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

import java.util.ArrayList;

public class AccumulationMetric extends Metric<ArrayList<Metric>> {
/**
     * constructor
     * 
     * @param aName - name of metric
     * @param aValue - current value of metric
     * @param aTarget - target value of metric
     */
    public AccumulationMetric(String aName, ArrayList<Metric> aValue, ArrayList<Metric> aTarget) {
        super(aName, aValue, aTarget);
    }
}
