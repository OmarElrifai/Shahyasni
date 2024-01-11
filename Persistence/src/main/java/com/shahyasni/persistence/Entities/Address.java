package com.shahyasni.persistence.Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

    @Column(name = "Street")
    private String street;

    @Column(name = "Block")
    private String block;

    @Column(name = "Sight")
    private String sight;


    public String getStreet() { return street; }
    public String getSight() { return sight; };


    public void setStreet(String street) {
        this.street = street;
    }

    public void setSight(String landscape) {
        this.sight = landscape;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
