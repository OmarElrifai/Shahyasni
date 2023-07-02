package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.PropertyTypes.PrivateProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PrivatePropertyFacilities implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "PropertyID")
    private PrivateProperty property;

    @Column(name = "Facility")
    private String facility;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public PrivateProperty getProperty() {
        return property;
    }

    public void setProperty(PrivateProperty property) {
        this.property = property;
    }

    public String getFacility() {
        return facility;
    }

    public void setFacility(String facility) {
        this.facility = facility;
    }
}
