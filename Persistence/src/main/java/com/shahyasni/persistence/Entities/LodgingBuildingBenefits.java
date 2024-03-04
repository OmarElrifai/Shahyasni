package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Enums.BenefitType;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LodgingBuildingBenefits implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "BenefitType")
    private BenefitType benefitType;

    @ManyToOne
    @JoinColumn(name = "LodgingBuildingId")
    @JsonbTransient
    private LodgingBuilding lodgingBuilding;

    @Column(name = "Benefit")
    private String benefit;

    @Column(name = "Highlighted")
    private Boolean highlighted;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BenefitType getBenefitType() {
        return benefitType;
    }

    public void setBenefitType(BenefitType benefitType) {
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

    public Boolean getHighlighted() {
        return highlighted;
    }

    public void setHighlighted(Boolean highlighted) {
        this.highlighted = highlighted;
    }
}
