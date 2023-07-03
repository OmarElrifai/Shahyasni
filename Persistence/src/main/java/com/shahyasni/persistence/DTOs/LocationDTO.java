package com.shahyasni.persistence.DTOs;


public class LocationDTO {

    private String city;
    private String governerate;


    public LocationDTO(String city, String governerate) {
        this.city = city;
        this.governerate = governerate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGovernerate() {
        return governerate;
    }

    public void setGovernerate(String governerate) {
        this.governerate = governerate;
    }
}
