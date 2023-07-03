package com.shahyasni.persistence.Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class Address {

    @Column(name = "Street")
    private String street;

    @Column(name = "Block")
    private String block;

    @Column(name = "Landscape")
    private String landscape;


    public String getStreet() { return street; }
    public String getLandscape() { return landscape; };


    public void setStreet(String street) {
        this.street = street;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }
}
