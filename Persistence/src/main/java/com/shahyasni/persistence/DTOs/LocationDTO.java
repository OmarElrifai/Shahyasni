package com.shahyasni.persistence.DTOs;


import com.shahyasni.persistence.Entities.City;
import com.shahyasni.persistence.Entities.Location;

import java.beans.ConstructorProperties;

public class LocationDTO {

    private Integer id;
    private Integer cityId;
    private String city;
    private String governerate;
    private String sight;



    @ConstructorProperties({"cityId","sight"})
    public LocationDTO(Integer cityId, String sight) {
        this.cityId = cityId;
        this.sight = sight;
    }


     public LocationDTO(String city, String sight,String governerate) {
        this.city = city;
        this.sight = sight;
        this.governerate = governerate;
    }




    public String getSight() {
        return sight;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Location toLocationEntity(Location location, City city){
        location.setSight(this.sight);
        location.setCity(city);
        return location;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getGovernerate() {
        return governerate;
    }

    public void setGovernerate(String governerate) {
        this.governerate = governerate;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
