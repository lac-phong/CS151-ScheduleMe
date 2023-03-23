/*
 * Entity.java
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package scheduleme;

import java.util.ArrayList;
import java.util.Date;

public abstract class Entity {
    private String name;
    private Role role;
    private Boolean isDisabled;
    private Date creationDate;
    private ArrayList<Goal> goals;

    public Entity() {

    }

    public Entity(String aName, Role aRole, Boolean aIsDisabled) {
        name = aName;
        role = aRole;
        isDisabled = aIsDisabled;
    }

    public String getName() {
        return name;
    }

    public void setName(String aName) {
        name = aName;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role aRole) {
        role = aRole;
    }

    public Boolean getIsDisabled() {
        return isDisabled;
    }

    public void setIsDisabled(Boolean aIsDisabled) {
        isDisabled = aIsDisabled;
    }

    public void addGoal(Goal aGoal) {
        goals.add(aGoal);
    }

    public void removeGoal(Goal aGoal) {
        for (int i = 0; i < goals.size(); i++) {
            if (goals.get(i) == aGoal) {
                goals.remove(i);
                break;
            }
        }
    }

    public ArrayList<Goal> getGoals() {
        return goals;
    }

    public Schedule getSchedule() {
        // TO DO
        return new Schedule();
    }
}
