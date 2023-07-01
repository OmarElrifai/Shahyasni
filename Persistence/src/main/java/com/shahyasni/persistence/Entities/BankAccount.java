package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;


    public BankAccount(){

    }

    public Integer getID() { return ID; }


    public void setID(Integer ID) {
        this.ID = ID;
    }
}
