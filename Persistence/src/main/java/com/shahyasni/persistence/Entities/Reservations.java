package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Reservations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;


    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;


    public Reservations(){

    }

    public Integer getId() { return ID; }
    public User getUser() { return user; }


    public void setId(Integer ID) {
        this.ID = ID;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
