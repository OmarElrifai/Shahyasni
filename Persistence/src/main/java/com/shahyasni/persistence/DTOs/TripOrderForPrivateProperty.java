package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.Location;

import java.time.LocalDate;
import java.time.LocalTime;

public class TripOrderForPrivateProperty {
    private Integer id;
    private String userName;
    private String tripDetails;
    private Location location;
    private Integer seats;
    private String transportationCompany;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private double dueAmmount;
    private String propertyType;


    public TripOrderForPrivateProperty(Integer id, String userName, String tripDetails , Location location, Integer seats, String transportationCompany, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, double dueAmmount, String propertyType){
        this.id = id;
        this.userName = userName;
        this.tripDetails = tripDetails;
        this.location = location;
        this.seats = seats;
        this.transportationCompany = transportationCompany;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.dueAmmount = dueAmmount;
        this.propertyType = propertyType;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTripDetails() {
        return tripDetails;
    }

    public void setTripDetails(String tripDetails) {
        this.tripDetails = tripDetails;
    }


    public String getTransportationCompany() {
        return transportationCompany;
    }

    public void setTransportationCompany(String transportationCompany) {
        this.transportationCompany = transportationCompany;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public double getDueAmmount() {
        return dueAmmount;
    }

    public void setDueAmmount(double dueAmmount) {
        this.dueAmmount = dueAmmount;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }
}
