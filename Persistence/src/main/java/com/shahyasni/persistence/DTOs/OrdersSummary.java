package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.Location;

import java.time.LocalDate;
import java.util.List;

public class OrdersSummary {
    private String fname;
    private String lname;
    private String username;
    private List<Location> locations;
    private double price;
    private LocalDate departureDate;


    public OrdersSummary(List<Location> locations, double price, LocalDate departureDate, String fname, String lname, String username) {
        this.locations = locations;
        this.price = price;
        this.departureDate = departureDate;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
    }


    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
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
}
