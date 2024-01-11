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
    private Integer id;

    public Transportation(){

    }



    @Column(name = "TransportationCompanyName")
    private String companyName;



    @Column(name = "DepartureDate")
    private LocalDate departureDate;

    @Column(name = "DepartureTime")
    private LocalTime departureTime;

    @Column(name = "ArrivalDate")
    private LocalDate arrivalDate;

    @Column(name = "ArrivalTime")
    private LocalTime arrivalTime;

    @Column(name = "PricePerSeat")
    private double price;




    public Integer getId() { return id; }
    public String getCompanyName() { return companyName; }
    public LocalDate getDepartureDate() {  return departureDate; }
    public LocalTime getDepartureTime() { return departureTime; }
    public LocalDate getArrivalDate() { return arrivalDate; }
    public LocalTime getArrivalTime() { return arrivalTime; }




    public void setId(Integer id) {
        this.id = id;
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



    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
