package com.shahyasni.persistence.DTOs;


import java.time.LocalDate;
import java.time.LocalTime;

public class TripDTO {

    private String tripTitle;
    private String sight;
    private String activity;
    private double price;
    private LocalDate departureDate;
    private LocalTime departureTime;


    public TripDTO(String tripTitle, String sight, String activity, double price){
        this.tripTitle = tripTitle;
        this.sight = sight;
        this.activity = activity;
        this.price = price;
    }




    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTripTitle() {
        return tripTitle;
    }

    public void setTripTitle(String tripTitle) {
        this.tripTitle = tripTitle;
    }

    public String getSight() {
        return sight;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
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
}
