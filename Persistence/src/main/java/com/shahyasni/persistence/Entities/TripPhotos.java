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
    @JoinColumn(name = "TripID")
    private Trip tripID;

    @Column(name = "Photo")
    private byte[] Photo;


    public Integer getId() { return id; }
    public Trip getTripID() { return tripID; }
    public byte[] getPhoto() { return Photo; }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setTripID(Trip tripID) {
        this.tripID = tripID;
    }

    public void setPhoto(byte[] photo) {
        Photo = photo;
    }
}
