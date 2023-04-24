/*
 * Dependency.java
 * 
 * Represents a dependent goal.
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

public class Dependency {
    private String name;            // The name of the dependent goal
    private Boolean isFulfilled;    // Whether the dependent goal is fulfilled
    private Goal dependency;        // The dependent goal

    /**
     * constructor
     * 
     * @param aName - the name of the dependent goal
     * @param aIsFulfilled - whether the dependent goal is fulfilled
     * @param aDependency - the dependent goal
     */
    public Dependency(String aName, Boolean aIsFulfilled, Goal aDependency) {
        name = aName;
        isFulfilled = aIsFulfilled;
        dependency = aDependency;
    }

    /**
     * getName
     * 
     * @return String - the name of the dependent goal
     */
    public String getName() {
        return name;
    }

    /**
     * setName
     * 
     * @param aName - the name of the dependent goal 
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * getIsFulfilled
     * 
     * @return Boolean - whether the dependent goal is fulfilled
     */
    public Boolean getIsFulfilled() {
        return isFulfilled;
    }

    /**
     * setIsFulfilled
     * 
     * @param aIsFulfilled - whether the dependent goal is fulfilled
     */
    public void setIsFulfilled(Boolean aIsFulfilled) {
        isFulfilled = aIsFulfilled;
    }

    /**
     * getDependency
     * 
     * @return Goal - the dependent goal
     */
    public Goal getDependency() {
        return dependency;
    }

    /**
     * setDependency
     * 
     * @param aGoal - the dependent goal
     */
    public void setDependency(Goal aGoal) {
        dependency = aGoal;
    }
}