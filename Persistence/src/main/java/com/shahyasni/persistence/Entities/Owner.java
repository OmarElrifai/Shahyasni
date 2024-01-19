package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName")
    private String lastName;

    @OneToMany(mappedBy = "owner")
    @JsonbTransient
    private List<PrivateProperty> privateProperties;

    @OneToMany(mappedBy = "owner")
    @JsonbTransient
    private List<LodgingBuilding> lodgingBuildings;


    @Column(name = "Street")
    private String street;

    @Column(name = "Block")
    private String block;

    @Column(name = "Landmark")
    private String landmark;

    @ManyToOne
    @JoinColumn(name = "City")
    private City city;

    public Integer getId() { return id; }



    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }


    public void setId(Integer ID) {

        this.id = ID;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<PrivateProperty> getPrivateProperties() {
        return privateProperties;
    }

    public void setPrivateProperties(List<PrivateProperty> privateProperties) {
        this.privateProperties = privateProperties;
    }

    public List<LodgingBuilding> getLodgingBuildings() {
        return lodgingBuildings;
    }

    public void setLodgingBuildings(List<LodgingBuilding> lodgingBuildings) {
        this.lodgingBuildings = lodgingBuildings;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getBlock() {
        return block;
    }

    public void setBlock(String block) {
        this.block = block;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
