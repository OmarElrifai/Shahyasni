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
    private Integer noOfSingleRooms;

    @Column(name = "DoubleRooms")
    private Integer noOfDoubleRooms;

    @Column(name = "TripleRooms")
    private Integer noOfTripleRooms;

    @Column(name = "FromDate")
    private LocalDate fromDate;

    @Column(name = "ToDate")
    private LocalDate toDate;

    @Column(name = "TotalDueAmount")
    private double totalDuePrice;

    public Reservations(){

    }

    public Integer getId() { return id; }
    public void setId(Integer ID) {
        this.id = id;
    }

    public Integer getNoOfSingleRooms() {
        return noOfSingleRooms;
    }

    public void setNoOfSingleRooms(Integer totalDueAmount) {
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

    public Integer getNoOfDoubleRooms() {
        return noOfDoubleRooms;
    }

    public void setNoOfDoubleRooms(Integer noOfDoubleRooms) {
        this.noOfDoubleRooms = noOfDoubleRooms;
    }

    public Integer getNoOfTripleRooms() {
        return noOfTripleRooms;
    }

    public void setNoOfTripleRooms(Integer noOfTripleRooms) {
        this.noOfTripleRooms = noOfTripleRooms;
    }

    public double getTotalDuePrice() {
        return totalDuePrice;
    }

    public void setTotalDuePrice(double totalDuePrice) {
        this.totalDuePrice = totalDuePrice;
    }
}
