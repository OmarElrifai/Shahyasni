package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.PropertyTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.PropertyTypes.PrivateProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Location implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "City")
    private String city;

    @Column(name = "Governerate")
    private String governerate;

    @OneToMany(mappedBy = "location")
    private List<Transportation> transportation;

    @OneToMany(mappedBy = "location")
    private List<LodgingBuilding> lodgingBuilding;

    @OneToMany(mappedBy = "location")
    private List<PrivateProperty> privateProperty;

    @OneToMany(mappedBy = "location")
    private List<Company> company;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Transportation> getTransportation() {
        return transportation;
    }

    public void setTransportation(List<Transportation> transportation) {
        this.transportation = transportation;
    }

    public List<LodgingBuilding> getLodgingBuilding() {
        return lodgingBuilding;
    }

    public void setLodgingBuilding(List<LodgingBuilding> lodgingBuilding) {
        this.lodgingBuilding = lodgingBuilding;
    }

    public List<PrivateProperty> getPrivateProperty() {
        return privateProperty;
    }

    public void setPrivateProperty(List<PrivateProperty> privateProperty) {
        this.privateProperty = privateProperty;
    }

    public List<Company> getCompany() {
        return company;
    }

    public void setCompany(List<Company> company) {
        this.company = company;
    }
}
