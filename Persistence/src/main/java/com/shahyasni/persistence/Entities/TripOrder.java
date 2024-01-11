package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.ReservationType.LodgingBuildingReservation;
import com.shahyasni.persistence.Entities.ReservationType.PrivatePropertyReservation;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
public class TripOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Trip")
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "Transportation")
    private Transportation transportation;

    @ElementCollection
    @CollectionTable(name = "AvailableSeats", joinColumns = @JoinColumn(name = "TripOrder"))
    private List<Integer> seats;

    @Column(name = "OrderCreationDate")
    private LocalDate orderCreationDate;

    @Column(name = "TotalDueAmount")
    private double totalDueAmount;

    @OneToOne
    @JoinColumn(name = "LodgingBuildingReservation")
    private LodgingBuildingReservation lodgingBuildingReservation;

    @OneToOne
    @JoinColumn(name = "PrivatePropertyReservation")
    private PrivatePropertyReservation privatePropertyReservation;


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

    public LodgingBuildingReservation getLodgingBuildingReservation() {
        return lodgingBuildingReservation;
    }

    public void setLodgingBuildingReservation(LodgingBuildingReservation lodgingBuildingReservation) {
        this.lodgingBuildingReservation = lodgingBuildingReservation;
    }

    public PrivatePropertyReservation getPrivatePropertyReservation() {
        return privatePropertyReservation;
    }

    public void setPrivatePropertyReservation(PrivatePropertyReservation privatePropertyReservation) {
        this.privatePropertyReservation = privatePropertyReservation;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
