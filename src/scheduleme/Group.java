/*
 * Group.java
 * 
 * VERSION HISTORY
 * v0.0.1   20230321   TAM   initial implementation
 *  
 */

package scheduleme;

import java.util.ArrayList;

public class Group extends Entity {
    private ArrayList<User> users;
    private Boolean isPublic;

    public Group(Boolean aIsPublic) {
        super();
        isPublic = aIsPublic;
    }

    public void addUser(User aUser) {
        users.add(aUser);
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void removeUser(User aUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i) == aUser) {
                users.remove(i);
                break;
            }
        }
    }
}