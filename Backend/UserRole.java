/*
 * UserRole.java
 * 
 * Represents normal (unprivileged) role
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

public class UserRole extends Role {
    /**
     * constructor
     * 
     * @param aName - the name of the role
     */
    public UserRole(String aName) {
        super(aName);
    }
}
