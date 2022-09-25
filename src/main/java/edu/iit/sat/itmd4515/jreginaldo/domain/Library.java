package edu.iit.sat.itmd4515.jreginaldo.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Library {

    public Library() {

    }

    public Library(String name, String streetAdd, String phoneNum) {
        this.name = name;
        this.streetAdd = streetAdd;
        this.phoneNum = phoneNum;
    }

    @Id
    private String name;
    private String streetAdd;
    private String phoneNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreetAdd() {
        return streetAdd;
    }

    public void setStreetAdd(String streetAdd) {
        this.streetAdd = streetAdd;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return "Library{" +
                "name='" + name + '\'' +
                ", streetAdd='" + streetAdd + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
