package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Reservations implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "TotalDueAmount")
    private double totalDueAmount;


    public Reservations(){

    }

    public Integer getId() { return id; }
    public void setId(Integer ID) {
        this.id = id;
    }

    public double getTotalDueAmount() {
        return totalDueAmount;
    }

    public void setTotalDueAmount(double totalDueAmount) {
        this.totalDueAmount = totalDueAmount;
    }
}
