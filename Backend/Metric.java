/*
 * Metric.java
 * 
 * Base class for all metric classes
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

import java.util.Date;

public abstract class Metric<T> {
    private String name;            // name of netric
    private Date dateAdded;         // date metric created
    private Date dateAccomplished;  // date metric accomplished
    protected T value;              // current value of metric
    protected T target;             // target value of metric

    /**
     * constructor
     * 
     * @param aName - name of metric
     * @param aValue - current value of metric
     * @param aTarget - target value of metric
     */
    public Metric(String aName, T aValue, T aTarget) {
        name = aName;
        dateAdded = new Date();
        dateAccomplished = null;
        value = aValue;
        target = aTarget;
    }

    /**
     * getName
     * 
     * @return String - name of metric
     */
    public String getName() {
        return name;
    }

    /**
     * setName
     * 
     * @param aName - name of metric
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * getDateAdded
     * 
     * @return Date - date metric created
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * setDateAdded
     * 
     * @param aDateAdded - date metric created
     */
    public void setDateAdded(Date aDateAdded) {
        dateAdded = aDateAdded;
    }

    /**
     * getDateAccomplished
     * 
     * @return Date - date metric accomplished
     */
    public Date getDateAccomplished() {
        return dateAccomplished;
    }

    /**
     * setDateAccomplished
     * 
     * @param aDateAccomplished - date metric accomplished
     */
    public void setDateAccomplished(Date aDateAccomplished) {
        dateAccomplished = aDateAccomplished;
    }

    /**
     * getValue
     * 
     * @return T - current value of metric
     */
    public T getValue() {
        return value;
    };

    /**
     * setValue
     * 
     * @param aValue - current value of metric
     */
    public void setValue(T aValue) {
        value = aValue;
    }

    /**
     * getTarget
     * 
     * @return T - target value of metric
     */
    public T getTarget() {
        return target;
    }

    /**
     * setTarget
     * 
     * @param aValue - target value of metric
     */
    public void setTarget(T aValue) {
        value = aValue;
    }
}