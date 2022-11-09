package edu.iit.sat.itmd4515.jreginaldo.security;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// General structure as demo'd in class

@Entity
@Table(name = "sec_user")
public class User {
    public User() {

    }

    /*
        ========== OBJECT RELATED VARIABLES ==========
     */
    @Id
    private String userName;
    private String password;

    // Many users to belong to many groups
    // E.g. A patron can be a member, employee, and admin

    @ManyToMany
    // User (Owner) -- Group (Owned)
    @JoinTable(name = "sec_user_groups",
                joinColumns = @JoinColumn(name = "USERNAME"),
                inverseJoinColumns = @JoinColumn(name = "GROUPNAME"))
    private List<Group> groups = new ArrayList<>();

    /*
        ========== GETTER / SETTER ==========
     */
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    /*
        ========== HELPER METHODS ==========
     */
    public void addGroup(Group g) {
        this.groups.add(g);
        g.getUsers().add(this);
    }

    public void removeGroup(Group g) {
        this.groups.remove(g);
        g.getUsers().remove(this);
    }
}
