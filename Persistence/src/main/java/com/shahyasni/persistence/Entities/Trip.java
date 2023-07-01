package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;

    @ManyToMany(mappedBy = "trips")
    private List<User> users;

    @Column(name = "TripDate")
    private LocalDate dateOfTrip;

    @Column(name = "TripHour")
    private LocalTime time;

    @Column(name = "Destination")
    private String Location;

    @Column(name = "PickUpLocation")
    private String pickUpLocation;

    @OneToMany(mappedBy = "tripID")
    private List<TripPhotos> photos;

    public Trip() {

    }

    public Integer getID() { return ID; }
    public List<User> getUsers() { return users; }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
