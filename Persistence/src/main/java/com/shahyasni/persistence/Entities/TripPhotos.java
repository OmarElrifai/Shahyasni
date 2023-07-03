package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class TripPhotos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Trip")
    private Trip trip;

    @Column(name = "Photo")
    private byte[] Photo;


    public Integer getId() { return id; }
    public Trip getTripId() { return trip; }
    public byte[] getPhoto() { return Photo; }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTripID(Trip tripID) {
        this.trip = tripID;
    }

    public void setPhoto(byte[] photo) {
        Photo = photo;
    }
}
