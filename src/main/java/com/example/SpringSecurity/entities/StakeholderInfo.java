package com.example.SpringSecurity.entities;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class StakeholderInfo {

    @Id
    @GeneratedValue
    private int id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String address;
    @NotEmpty
    private String contactPersonName;
    @NotEmpty
    @Column(unique = true)
    private String contactPersonMobile;
    private boolean status;

    @OneToMany
    @JoinColumn(name = "stakeholderId" )
    private List<User> usersSet = new ArrayList<>();

    public StakeholderInfo() {
    }

    public StakeholderInfo(String name, String address, String contactPersonName, String contactPersonMobile, boolean status) {
        this.name = name;
        this.address = address;
        this.contactPersonName = contactPersonName;
        this.contactPersonMobile = contactPersonMobile;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactPersonName() {
        return contactPersonName;
    }

    public void setContactPersonName(String contactPersonName) {
        this.contactPersonName = contactPersonName;
    }

    public String getContactPersonMobile() {
        return contactPersonMobile;
    }

    public void setContactPersonMobile(String contactPersonMobile) {
        this.contactPersonMobile = contactPersonMobile;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<User> getUsersSet() {
        return usersSet;
    }

    public void setUsersSet(List<User> usersSet) {
        this.usersSet = usersSet;
    }
}
