/*
 * Group.java
 * 
 * Represents a group of users.
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package Backend;

import java.util.ArrayList;

public class Group extends Entity {
    private ArrayList<User> users;  // The users in the group
    private Boolean isPublic;       // Whether the group is public

    /**
     * constructor
     * 
     * @param aName - the name of the group
     * @param aRole - the role of the group
     * @param aIsDisabled - whether the group is disabled
     * @param aUsers - the users in the group
     * @param aIsPublic - whether the group is public
     */
    public Group(String aName, Role aRole, Boolean aIsDisabled, ArrayList<User> aUsers, Boolean aIsPublic) {
        super(aName, aRole, aIsDisabled);
        users = aUsers;
        isPublic = aIsPublic;
    }

    /**
     * getIsPublic
     * 
     * @return Boolean - whether the group is public
     */
    public Boolean getIsPublic() {
        return isPublic;
    }

    /**
     * setIsPublic
     * 
     * @param aIsPublic - whether the group is public
     */
    public void setIsPublic(Boolean aIsPublic) {
        isPublic = aIsPublic;
    }

    /**
     * addUser
     * 
     * @param aUser - the user to add to the group
     */
    public void addUser(User aUser) {
        users.add(aUser);
    }

    /**
     * getUsers
     * 
     * @return ArrayList<User> - the users in the group
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * removeUser
     * 
     * @param aUser - the user to remove from the group
     */
    public void removeUser(User aUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) == aUser) {
                users.remove(i);
                break;
            }
        }
    }
}