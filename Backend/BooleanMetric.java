/*
 * BooleanMetric.java
 * 
 * Represents a boolean metric (yes/no, done/not-done). For example, a goal to take out the trash.
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

public class BooleanMetric extends Metric<Boolean> {
    /**
     * constructor
     * 
     * @param aName - name of metric
     * @param aValue - current value of metric
     * @param aTarget - target value of metric
     */
    public BooleanMetric(String aName, Boolean aValue, Boolean aTarget) {
        super(aName, aValue, aTarget);
    }
}