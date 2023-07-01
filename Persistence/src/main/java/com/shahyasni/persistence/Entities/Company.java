package com.shahyasni.persistence.Entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class Company  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    public Integer ID;

    @Column(name = "Name")
    public String name;

    public Integer getID() { return ID; }
    public String getName() { return name; }


    public void setID(Integer ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Company(){

    }
}
