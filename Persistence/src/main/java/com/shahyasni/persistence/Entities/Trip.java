package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;

    @ManyToMany(mappedBy = "trips")
    private List<User> users = new ArrayList<>();

    @Column(name = "TripDetails")
    private String tripDetails;

    @Column(name = "TripDate")
    private LocalDate dateOfTrip;

    @Column(name = "TripHour")
    private LocalTime time;

    @Column(name = "Destination")
    private String destination;

    @Column(name = "PickUpLocation")
    private String pickUpLocation;

    @OneToMany(mappedBy = "tripID")
    private List<TripPhotos> photos = new ArrayList<>();;

    @ManyToOne
    @JoinColumn(name = "CompanyID")
    private Company company;

    @Column(name = "Price")
    private double price;





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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public LocalDate getDateOfTrip() {
        return dateOfTrip;
    }

    public void setDateOfTrip(LocalDate dateOfTrip) {
        this.dateOfTrip = dateOfTrip;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public String getDestination() {
        return destination;
    }

    public void setLocation(String destination) {
        this.destination = destination;
    }

    public String getPickUpLocation() {
        return pickUpLocation;
    }

    public void setPickUpLocation(String pickUpLocation) {
        this.pickUpLocation = pickUpLocation;
    }

    public List<TripPhotos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<TripPhotos> photos) {
        this.photos = photos;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(String tripDetails) {
        this.tripDetails = tripDetails;
    }
}
