package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.Location;

import java.time.LocalDate;
import java.util.List;

public class UserTrips {
    private Integer id;
    private String fname;
    private String lname;
    private String username;
    private Location locations;
    private Integer seats;
    private double price;
    private LocalDate departureDate;


    public UserTrips(Integer id,Location locations,Integer seats, double price, LocalDate departureDate, String fname, String lname, String username) {
        this.id = id;
        this.locations = locations;
        this.seats = seats;
        this.price = price;
        this.departureDate = departureDate;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
    }


    public Location getLocations() {
        return locations;
    }

    public void setLocations(Location locations) {
        this.locations = locations;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
