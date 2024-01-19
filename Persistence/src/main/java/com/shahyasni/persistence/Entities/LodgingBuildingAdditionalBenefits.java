package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Enums.BenefitType;
import com.shahyasni.persistence.Enums.Facilities;
import com.shahyasni.persistence.Enums.RoomFacilities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LodgingBuildingAdditionalBenefits implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "BenefitType")
    private BenefitType benefitType;

    @ManyToOne
    @JoinColumn(name = "Camp")
    private LodgingBuilding lodgingBuilding;

    @Column(name = "Benefit")
    private String benefit;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BenefitType getFacilityType() {
        return benefitType;
    }

    public void setFacilityType(BenefitType benefitType) {
        this.benefitType = benefitType;
    }


    public LodgingBuilding getLodgingBuilding() {
        return lodgingBuilding;
    }

    public void setLodgingBuilding(LodgingBuilding lodgingBuilding) {
        this.lodgingBuilding = lodgingBuilding;
    }


    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
}
