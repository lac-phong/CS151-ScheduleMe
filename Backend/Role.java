/*
 * Role.java
 * 
 * The base class for all roles in ScheduleMe.
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

public abstract class Role {
    private String name;    // The name of the role

    /**
     * constructor
     * 
     * @param aName - the name of the role
     */
    public Role(String aName) {
        name = aName;
    }

    /**
     * getName
     * 
     * @return String - the name of the role
     */
    public String getName() {
        return name;
    }

    /**
     * setName
     * 
     * @param aName - the name of the role
     */
    public void setName(String aName) {
        name = aName;
    }
}