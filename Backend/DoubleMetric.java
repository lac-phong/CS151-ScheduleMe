/*
 * DoubleMetric.java
 * 
 * Represents a metric identified by a double value. For example, a goal of saving $30.95.
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

public class DoubleMetric extends Metric<Double> {
/**
     * constructor
     * 
     * @param aName - name of metric
     * @param aValue - current value of metric
     * @param aTarget - target value of metric
     */
    public DoubleMetric(String aName, Double aValue, Double aTarget) {
        super(aName, aValue, aTarget);
    }
}