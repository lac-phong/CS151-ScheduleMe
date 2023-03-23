/*
 * Goal.java
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package scheduleme;

import java.util.ArrayList;
import java.util.Date;

public class Goal {
    private ArrayList<Entity> entities;
    private String shortName;
    private String description;
    private Priority priority;
    private Boolean isPublic;
    private ArrayList<Goal> subGoals;
    private ArrayList<Dependency> dependencies;
    private Metric target;
    private Boolean isAccomplished;
    private Date dateAdded;
    private Date dateAccomplished;

    public Goal() {

    }

    public void addEntity(Entity aEntity) {
        entities.add(aEntity);
    }

    public void removeEntity(Entity aEntity) {
        for (int i = 0; i < entities.size(); i++) {
            if (entities.get(i) == aEntity) {
                entities.remove(aEntity);
                break;
            }
        }
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String aShortName) {
        shortName = aShortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String aDescription) {
        description = aDescription;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority aPriority) {
        priority = aPriority;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean aIsPublic) {
        isPublic = aIsPublic;
    }

    public Metric getTarget() {
        return target;
    }

    public void setTarget(Metric aTarget) {
        target = aTarget;
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
}
