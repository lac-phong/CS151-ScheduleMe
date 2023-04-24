/*
 * Entity.java
 * 
 * Represents a entity using the system (a group or an individual).
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

import java.util.ArrayList;
import java.util.Date;

public abstract class Entity {
    private String name;            // The name of the entity
    private Role role;              // The role of the entity
    private Boolean isDisabled;     // Whether the entity is disabled
    private Date creationDate;      // The date the entity was created
    private ArrayList<Goal> goals;  // The goals of the entity

    /**
     * constructor
     * 
     * @param aName - the name of the entity
     * @param aRole - the role of the entity
     * @param aIsDisabled - whether the entity is disabled
     */
    public Entity(String aName, Role aRole, Boolean aIsDisabled) {
        name = aName;
        role = aRole;
        isDisabled = aIsDisabled;
    }

    /**
     * getName
     * 
     * @return String - the name of the entity
     */
    public String getName() {
        return name;
    }

    /**
     * setName
     * 
     * @param aName - the name of the entity
     */
    public void setName(String aName) {
        name = aName;
    }

    /**
     * getRole
     * 
     * @return Role - the role of the entity
     */
    public Role getRole() {
        return role;
    }

    /**
     * setRole
     * 
     * @param aRole - the role of the entity
     */
    
    public void setRole(Role aRole) {
        role = aRole;
    }

    /**
     * getIsDisabled
     * 
     * @return Boolean - whether the entity is disabled
     */
    public Boolean getIsDisabled() {
        return isDisabled;
    }

    /**
     * setIsDisabled
     * 
     * @param aIsDisabled - whether the entity is disabled
     */
    public void setIsDisabled(Boolean aIsDisabled) {
        isDisabled = aIsDisabled;
    }

    /**
     * getCreationDate
     * 
     * @return Date - the date the entity was created
     */
    public Date getCreationDate() {
        return creationDate;
    }

    /**
     * setCreationDate
     * 
     * @param aCreationDate - the date the entity was created
     */
    public void setCreationDate(Date aCreationDate) {
        creationDate = aCreationDate;
    }

    /**
     * addGoal
     * 
     * @param aGoal - the goal to add
     */
    public void addGoal(Goal aGoal) {
        goals.add(aGoal);
    }

    /**
     * removeGoal
     * 
     * @param aGoal - the goal to remove
     */
    
    public void removeGoal(Goal aGoal) {
        for (int i = 0; i < goals.size(); i++) {
            if (goals.get(i) == aGoal) {
                goals.remove(i);
                break;
            }
        }
    }

    /**
     * getGoals
     * 
     * @return ArrayList<Goal> - the goals of the entity
     */
    public ArrayList<Goal> getGoals() {
        return goals;
    }

    /**
     * setGoals
     * 
     * @param aGoals - the goals of the entity
     */
    public Schedule getSchedule() {
        // TO DO
        return new Schedule();
    }
}
