package com.shahyasni.persistence.Entities.ReservationType;

import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.Reservations;
import com.shahyasni.persistence.Entities.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PrivatePropertyReservation extends Reservations {

    @ManyToOne
    @JoinColumn(name = "User")
    private User user;


    @ManyToOne
    @JoinColumn(name = "PrivateProperty")
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
