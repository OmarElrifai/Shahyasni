package com.shahyasni.persistence.DTOs;

import java.time.LocalDate;
import java.time.LocalTime;

public class OrderDetails {
    private Integer id;
    private String userName;
    private String tripDetails;
    private String city;
    private String transportationCompany;
    private LocalDate departureDate;
    private LocalTime departureTime;
    private LocalDate arrivalDate;
    private LocalTime arrivalTime;
    private double dueAmmount;


    public OrderDetails(Integer id, String username, String tripDetails, String city, String transportationCompany, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, double dueAmmount){
        this.userName = username;
        this.tripDetails = tripDetails;
        this.city = city;
        this.transportationCompany = transportationCompany;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalDate = arrivalDate;
        this.arrivalTime = arrivalTime;
        this.dueAmmount = dueAmmount;
        this.id = id;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
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
}
