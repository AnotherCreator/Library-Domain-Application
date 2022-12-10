package edu.iit.sat.itmd4515.jreginaldo.security;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

// General structure as demo'd in class

@Entity
@Table(name = "sec_group")
@NamedQuery(name = "Group.findAll", query = "SELECT g FROM Group g")
public class Group {

    public Group() {

    }

    public Group(String groupName, String groupDesc) {
        this.groupName = groupName;
        this.groupDesc = groupDesc;
    }

    /*
            ========== OBJECT RELATED VARIABLES ==========
    */
    @Id
    private String groupName;
    private String groupDesc;
    // User (Owner) -- Group (Owned)

    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();

    /*
        ========== GETTER / SETTER ==========
    */
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

//    @Override
//    public String toString() {
//        return "Group{" +
//                "groupName='" + groupName + '\'' +
//                ", groupDesc='" + groupDesc + '\'' +
//                ", users=" + users +
//                '}';
//    }
}
