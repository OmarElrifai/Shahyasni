package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Transportation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String ID;

    public Transportation(){

    }



    @Column(name = "TransportationCompanyName")
    private String companyName;

    @Column(name = "Location")
    private String location;

    @Column(name = "DepartureDate")
    private LocalDate departureDate;

    @Column(name = "DepartureTime")
    private LocalTime departureTime;

    @Column(name = "ArrivalDate")
    private LocalDate arrivalDate;

    @Column(name = "ArrivalTime")
    private LocalTime arrivalTime;


    @ElementCollection
    @CollectionTable(name = "Seats", joinColumns = @JoinColumn(name = "Transportation"))
    List<Integer> seats;


    public String getID() { return ID; }
    public String getCompanyName() { return companyName; }
    public LocalDate getDepartureDate() {  return departureDate; }
    public LocalTime getDepartureTime() { return departureTime; }
    public LocalDate getArrivalDate() { return arrivalDate; }
    public LocalTime getArrivalTime() { return arrivalTime; }




    public void setID(String ID) {
        this.ID = ID;
    }


    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
