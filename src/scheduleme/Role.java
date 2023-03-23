/*
 * Role.java
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package scheduleme;

public abstract class Role {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }
}