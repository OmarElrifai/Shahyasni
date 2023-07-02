package com.shahyasni.persistence.Entities.ReservationType;

import com.shahyasni.persistence.Entities.PropertyTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.Reservations;
import com.shahyasni.persistence.Entities.User;

import javax.persistence.*;

@Entity
public class LodgingBuildingReservation extends Reservations {

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "LodgingBuildingID")
    private LodgingBuilding lodgingBuilding;

    @Column(name = "NoOfRooms")
    private Integer noOfRooms;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LodgingBuilding getLodgingBuilding() {
        return lodgingBuilding;
    }

    public void setLodgingBuilding(LodgingBuilding lodgingBuilding) {
        this.lodgingBuilding = lodgingBuilding;
    }

    public Integer getNoOfRooms() {
        return noOfRooms;
    }

    public void setNoOfRooms(Integer noOfRooms) {
        this.noOfRooms = noOfRooms;
    }
}
