/*
 * Metric.java
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package scheduleme;

import java.util.Date;

public abstract class Metric<T> {
    private String name;
    private Date dateAdded;
    private Date dateAccomplished;
    protected T value;
    protected T target;

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date aDateAdded) {
        dateAdded = aDateAdded;
    }

    public Date getDateAccomplished() {
        return dateAccomplished;
    }

    public void setDateAccomplished(Date aDateAccomplished) {
        dateAccomplished = aDateAccomplished;
    }

    public T getValue() {
        return value;
    };

    public void setValue(T aValue) {
        value = aValue;
    }

    public T getTarget() {
        return target;
    }

    public void setTarget(T aValue) {
        value = aValue;
    }
}