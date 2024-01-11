package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Trip implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

//    @ManyToMany(mappedBy = "tripsOrders")
//    private List<User> users = new ArrayList<>();


    @Column(name = "TripTitle")
    private String tripTitle;

    @Column(name = "TripDetails")
    private String tripDetails;

    @ElementCollection
    @CollectionTable(name = "Transportations",joinColumns = @JoinColumn(name="Trip"))
    private List<Transportation> Transportation;


    @ManyToMany
    @JoinTable(name = "TripsLocations", joinColumns = @JoinColumn(name = "Trip"),inverseJoinColumns = @JoinColumn(name = "Location"))
    private List<Location> locations;

    @ManyToMany
    @JoinTable(name = "TripActivities", joinColumns = @JoinColumn(name = "Trip"),inverseJoinColumns = @JoinColumn(name = "Activities"))
    private List<Activity> activities;

    @Column(name = "PickUpLocation")
    private String pickUpLocation;

    @OneToMany(mappedBy = "trip")
    private List<TripPhotos> photos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "CompanyResources")
    private Company company;

    @Column(name = "Price")
    private double price;

    @ManyToMany
    @JoinTable(name = "TripsLodgingBuilding",joinColumns = @JoinColumn(name = "Trips"),inverseJoinColumns = @JoinColumn(name = "LodgingAccomodations"))
    private List<LodgingBuilding> lodgingBuildings;

    @ManyToMany
    @JoinTable(name = "TripsPrivateProperty",joinColumns = @JoinColumn(name = "Trips"),inverseJoinColumns = @JoinColumn(name = "PrivateBuildings"))
    private List<PrivateProperty> privateProperties;
//
    @OneToMany(mappedBy = "trip")
    private List<TripOrder> tripOrder;


    public Trip() {

    }

    public Integer getId() { return id; }
//    public List<User> getUsers() { return users; }

    public void setId(Integer id) {
        this.id = id;
    }

//    public void setUsers(List<User> users) {
//        this.users = users;
//    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Location> getLocation() {
        return locations;
    }

    public void setLocation(List<Location> location) {
        this.locations = location;
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

    public List<TripOrder> getTripOrder() {
        return tripOrder;
    }

    public void setTripOrder(List<TripOrder> tripOrder) {
        this.tripOrder = tripOrder;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public String getTripTitle() {
        return tripTitle;
    }

    public void setTripTitle(String tripTitle) {
        this.tripTitle = tripTitle;
    }

//    public List<TripOrder> getTripOrder() {
//        return tripOrder;
//    }
//
//    public void setTripOrder(List<TripOrder> tripOrder) {
//        this.tripOrder = tripOrder;
//    }
}
