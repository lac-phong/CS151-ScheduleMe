/*
 * Goal.java
 * 
 * Represents a goal.
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

import java.util.ArrayList;
import java.util.Date;

public class Goal {
    private ArrayList<Entity> entities;     // list of entities that have this goal
    private String shortName;               // short name of goal
    private String description;             // description of goal
    private Priority priority;              // priority of goal
    private Boolean isPublic;               // whether goal can be shared/viewed by public
    private ArrayList<Goal> subGoals;       // list of subgoals
    private ArrayList<Dependency> dependencies; // list of dependent goals
    private Metric target;                  // target metric for this goal
    private Boolean isAccomplished;         // whether this goal has been accomplished (target met)
    private Date dateAdded;                 // date goal created
    private Date dateAccomplished;          // date goal accomplished

    /**
     * default constructor
     */
    public Goal() {

    }

    /**
     * constructor
     * 
     * @param aShortName - short name of goal
     * @param aDescription - description of goal
     * @param aPriority - priority of goal
     * @param aIsPublic - whether goal can be shared/viewed by public
     * @param aTarget - target metric for this goal
     */
    public Goal(String aShortName, String aDescription, Priority aPriority, Boolean aIsPublic, Metric aTarget) {
        shortName = aShortName;
        description = aDescription;
        priority = aPriority;
        isPublic = aIsPublic;
        target = aTarget;
        isAccomplished = false;
        dateAdded = new Date();
        dateAccomplished = null;
    }

    /**
     * addEntity
     * 
     * @param anEntity - entity to add to list of entities that have this goal
     */
    public void addEntity(Entity anEntity) {
        entities.add(anEntity);
    }

    /**
     * removeEntity - remove an entity from this goal
     * 
     * @param anEntity - entity to remove from list of entities that have this goal
     */
    public void removeEntity(Entity anEntity) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) == anEntity) {
                entities.remove(anEntity);
                break;
            }
        }
    }

    /**
     * getEntities - return list of entities that have this goal
     * 
     * @return ArrayList<Entity> - list of entities that have this goal
     */
    public ArrayList<Entity> getEntities() {
        return entities;
    }


    public void addSubGoal(Goal aGoal) {
        subGoals.add(aGoal);
    }

    /**
     * removeSubGoal - remove a subgoal from this goal
     * 
     * @param aGoal - subgoal to remove from list of subgoals for this goal
     */
    public void removeSubGoal(Goal aGoal) {
        for (int i = 0; i < subGoals.size(); i++) {
            if (subGoals.get(i) == aGoal) {
                subGoals.remove(aGoal);
                break;
            }
        }
    }

    /**
     * getSubGoals - return list of subgoals for this goal
     * 
     * @return ArrayList<Goal> - list of subgoals for this goal
     */
    public ArrayList<Goal> getSubGoals() {
        return subGoals;
    }

    /**
     * addDependency
     * 
     * @param aDependency - dependency to add to list of dependencies for this goal
     */
    public void addDependency(Dependency aDependency) {
        dependencies.add(aDependency);
    }

    /**
     * removeDependency - remove a dependency from this goal
     * 
     * @param aDependency - dependency to remove from list of dependencies for this goal
     */
    public void removeDependency(Dependency aDependency) {
        for (int i = 0; i < dependencies.size(); i++) {
            if (dependencies.get(i) == aDependency) {
                dependencies.remove(aDependency);
                break;
            }
        }
    }

    /**
     * getDependencies - return list of dependencies for this goal
     * 
     * @return ArrayList<Dependency> - list of dependencies for this goal
     */
    public ArrayList<Dependency> getDependencies() {
        return dependencies;
    }

    /**
     * getShortName
     * 
     * @return String - short name of goal
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * setShortName
     * 
     * @param aShortName - short name of goal
     */
    public void setShortName(String aShortName) {
        shortName = aShortName;
    }

    /**
     * getDescription
     * 
     * @return String - description of goal
     */
    public String getDescription() {
        return description;
    }

    /**
     * setDescription
     * 
     * @param aDescription - description of goal
     */
    public void setDescription(String aDescription) {
        description = aDescription;
    }

    /**
     * getPriority
     * 
     * @return Priority - priority of goal
     */
    public Priority getPriority() {
        return priority;
    }

    /**
     * setPriority
     * 
     * @param aPriority - priority of goal
     */
    public void setPriority(Priority aPriority) {
        priority = aPriority;
    }

    /**
     * getIsPublic
     * 
     * @return Boolean - whether goal can be shared/viewed by public
     */
    public Boolean getIsPublic() {
        return isPublic;
    }

    /**
     * setIsPublic
     * 
     * @param aIsPublic - whether goal can be shared/viewed by public
     */
    public void setIsPublic(Boolean aIsPublic) {
        isPublic = aIsPublic;
    }

    /**
     * addSubGoal
     * 
     * @param aSubGoal - subgoal to add to list of subgoals
     */
    public Metric getTarget() {
        return target;
    }

    /**
     * setTarget
     * 
     * @param aTarget - target metric for this goal
     */
    public void setTarget(Metric aTarget) {
        target = aTarget;
    }

    /**
     * getIsAccomplished
     * 
     * @return Boolean - whether this goal has been accomplished (target met)
     */
    public Boolean getIsAccomplished() {
        return isAccomplished;
    }

    /**
     * setIsAccomplished
     * 
     * @param aIsAccomplished - whether this goal has been accomplished (target met)
     */
    public void setIsAccomplished(Boolean aIsAccomplished) {
        isAccomplished = aIsAccomplished;
    }
     
    /**
     * getDateAdded
     * 
     * @return Date - date goal created
     */
    public Date getDateAdded() {
        return dateAdded;
    }

    /**
     * setDateAdded
     * 
     * @param aDateAdded - date goal created
     */
    public void setDateAdded(Date aDateAdded) {
        dateAdded = aDateAdded;
    }

    /**
     * getDateAccomplished
     * 
     * @return Date - date goal accomplished
     */
    public Date getDateAccomplished() {
        return dateAccomplished;
    }

    /**
     * setDateAccomplished
     * 
     * @param aDateAccomplished - date goal accomplished
     */
    public void setDateAccomplished(Date aDateAccomplished) {
        dateAccomplished = aDateAccomplished;
    }
}
