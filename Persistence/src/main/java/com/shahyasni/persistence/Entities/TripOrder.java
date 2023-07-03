package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.PropertyTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.PropertyTypes.PrivateProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TripOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "User")
    private User user;

    @OneToOne
    @JoinColumn(name = "Trip")
    private Trip trip;

    @OneToOne
    @JoinColumn(name = "Transportation")
    private Transportation transportation;

    @ElementCollection
    @CollectionTable(name = "AvailableSeats", joinColumns = @JoinColumn(name = "TripOrder"))
    List<Integer> seats;

    @Column(name = "OrderCreationDate")
    private LocalDate orderCreationDate;

    @Column(name = "TotalDueAmount")
    private double totalDueAmount;

    @OneToOne
    @JoinColumn(name = "LodgingBuilding")
    private LodgingBuilding lodgingBuilding;

    @OneToOne
    @JoinColumn(name = "PrivateProperty")
    private PrivateProperty privateProperty;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }

    public LodgingBuilding getLodgingBuilding() {
        return lodgingBuilding;
    }

    public void setLodgingBuilding(LodgingBuilding lodgingBuilding) {
        this.lodgingBuilding = lodgingBuilding;
    }

    public PrivateProperty getPrivateProperty() {
        return privateProperty;
    }

    public void setPrivateProperty(PrivateProperty privateProperty) {
        this.privateProperty = privateProperty;
    }

    public Transportation getTransportation() {
        return transportation;
    }

    public void setTransportation(Transportation transportation) {
        this.transportation = transportation;
    }

    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }

    public double getTotalDueAmount() {
        return totalDueAmount;
    }

    public void setTotalDueAmount(double totalDueAmount) {
        this.totalDueAmount = totalDueAmount;
    }

    public LocalDate getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(LocalDate orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }
}
