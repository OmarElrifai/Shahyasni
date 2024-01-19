package com.shahyasni.persistence.Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "Street")
    private String street;

    @Column(name = "Block")
    private String block;

    @Column(name = "Landmark")
    private String landmark;


    public String getStreet() { return street; }
    public String getLandmark() { return landmark; };


    public void setStreet(String street) {
        this.street = street;
    }

    public void setLandscape(String landmark) {
        this.landmark = landmark;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
