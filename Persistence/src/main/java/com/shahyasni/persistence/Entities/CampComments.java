package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.PropertyOwnerEntities.Camp;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CampComments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User userID;

    @ManyToOne
    @JoinColumn(name = "CampID")
    private Camp campID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Camp getCampID() {
        return campID;
    }

    public void setCampID(Camp campID) {
        this.campID = campID;
    }
}
