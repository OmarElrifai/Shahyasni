package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@MappedSuperclass
public class Reservations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "SingleRooms")
    private double noOfSingleRooms;

    @Column(name = "DoubleRooms")
    private double noOfDoubleRooms;

    @Column(name = "TripleRooms")
    private double noOfTripleRooms;

    @Column(name = "FromDate")
    private LocalDate fromDate;

    @Column(name = "ToDate")
    private LocalDate toDate;

    @Column(name = "Price")
    private double price;

    public Reservations(){

    }

    public Integer getId() { return id; }
    public void setId(Integer ID) {
        this.id = id;
    }

    public double getNoOfSingleRooms() {
        return noOfSingleRooms;
    }

    public void setNoOfSingleRooms(double totalDueAmount) {
        this.noOfSingleRooms = totalDueAmount;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public double getNoOfDoubleRooms() {
        return noOfDoubleRooms;
    }

    public void setNoOfDoubleRooms(double noOfDoubleRooms) {
        this.noOfDoubleRooms = noOfDoubleRooms;
    }

    public double getNoOfTripleRooms() {
        return noOfTripleRooms;
    }

    public void setNoOfTripleRooms(double noOfTripleRooms) {
        this.noOfTripleRooms = noOfTripleRooms;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
