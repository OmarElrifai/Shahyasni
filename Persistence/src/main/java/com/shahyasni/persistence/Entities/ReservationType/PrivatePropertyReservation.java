package com.shahyasni.persistence.Entities.ReservationType;

import com.shahyasni.persistence.Entities.PropertyTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.PropertyTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.Reservations;
import com.shahyasni.persistence.Entities.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PrivatePropertyReservation extends Reservations {

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;


    @ManyToOne
    @JoinColumn(name = "PrivatePropertyID")
    private PrivateProperty privateProperty;



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public PrivateProperty getPrivateProperty() {
        return privateProperty;
    }

    public void setPrivateProperty(PrivateProperty privateProperty) {
        this.privateProperty = privateProperty;
    }
}
