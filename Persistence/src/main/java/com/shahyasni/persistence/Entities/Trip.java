package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.PropertyTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.PropertyTypes.PrivateProperty;

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
    private Integer id;

    @ManyToMany(mappedBy = "trips")
    private List<User> users = new ArrayList<>();

    @Column(name = "TripDetails")
    private String tripDetails;

    @ElementCollection
    @CollectionTable(name = "Transportations",joinColumns = @JoinColumn(name="Trip"))
    private List<Transportation> Transportation;


    @ManyToMany
    @JoinTable(name = "TripsLocations", joinColumns = @JoinColumn(name = "Trip"),inverseJoinColumns = @JoinColumn(name = "Location"))
    private List<Location> location;

    @Column(name = "PickUpLocation")
    private String pickUpLocation;

    @OneToMany(mappedBy = "trip")
    private List<TripPhotos> photos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Company")
    private Company company;

    @Column(name = "Price")
    private double price;

    @ManyToMany
    @JoinTable(name = "TripsLodgingBuilding",joinColumns = @JoinColumn(name = "Trips"),inverseJoinColumns = @JoinColumn(name = "LodgingAccomodations"))
    private List<LodgingBuilding> lodgingBuildings;

    @ManyToMany
    @JoinTable(name = "TripsPrivateProperty",joinColumns = @JoinColumn(name = "Trips"),inverseJoinColumns = @JoinColumn(name = "PrivateBuildings"))
    private List<PrivateProperty> privateProperties;




    public Trip() {

    }

    public Integer getId() { return id; }
    public List<User> getUsers() { return users; }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Location> getLocation() {
        return location;
    }

    public void setLocation(List<Location> location) {
        this.location = location;
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

    public List<LodgingBuilding> getLodgingBuildings() {
        return lodgingBuildings;
    }

    public void setLodgingBuildings(List<LodgingBuilding> lodgingBuildings) {
        this.lodgingBuildings = lodgingBuildings;
    }

    public List<PrivateProperty> getPrivateProperties() {
        return privateProperties;
    }

    public void setPrivateProperties(List<PrivateProperty> privateProperties) {
        this.privateProperties = privateProperties;
    }

    public List<com.shahyasni.persistence.Entities.Transportation> getTransportation() {
        return Transportation;
    }

    public void setTransportation(List<com.shahyasni.persistence.Entities.Transportation> transportation) {
        Transportation = transportation;
    }
}
