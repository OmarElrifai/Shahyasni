package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Enums.BenefitType;
import com.shahyasni.persistence.Enums.BenefitsTypes;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PrivatePropertyBenefits implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Property")
    private PrivateProperty property;

    @Column(name = "BenefitType")
    private BenefitType benefitType;


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

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }
 }
