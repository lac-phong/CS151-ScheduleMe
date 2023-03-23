/*
 * Dependency.java
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package scheduleme;

public class Dependency {
    private String name;
    private Boolean isFulfilled;
    private Goal dependency;

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public Boolean getIsFulfilled() {
        return isFulfilled;
    }

    public void setIsFulfilled(Boolean aIsFulfilled) {
        isFulfilled = aIsFulfilled;
    }

    public Goal getDependency() {
        return dependency;
    }

    public void setDependency(Goal aGoal) {
        dependency = aGoal;
    }
}