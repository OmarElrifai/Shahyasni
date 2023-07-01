package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.PropertyOwnerEntities.Camp;
import com.shahyasni.persistence.Enums.FacilityType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class CampAdditionalFacilities implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "FacilityType")
    private FacilityType facilityType;

    @ManyToOne
    @JoinColumn(name = "CampID")
    private Camp camp;

    @Column(name = "Facility")
    private String Facility;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FacilityType getFacilityType() {
        return facilityType;
    }

    public void setFacilityType(FacilityType facilityType) {
        this.facilityType = facilityType;
    }

    public String getFacility() {
        return Facility;
    }

    public void setFacility(String facility) {
        Facility = facility;
    }
}
