package com.shahyasni.persistence.Entities;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String governorate;
    private String city;
    private String street;
    private String landscape;

    public String getGovernorate() { return governorate; }
    public String getCity() { return city; }
    public String getStreet() { return street; }
    public String getLandscape() { return landscape; };



    public void setGovernorate(String governorate) {
        this.governorate = governorate;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setLandscape(String landscape) {
        this.landscape = landscape;
    }
}
