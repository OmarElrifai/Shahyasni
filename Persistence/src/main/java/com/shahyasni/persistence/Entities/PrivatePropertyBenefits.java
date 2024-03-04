package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Enums.BenefitType;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PrivatePropertyBenefits implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Property")
    @JsonbTransient
    private PrivateProperty property;

    @Column(name = "BenefitType")
    private BenefitType benefitType;


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

    public String getBenefit() {
        return benefit;
    }

    public void setBenefit(String benefit) {
        this.benefit = benefit;
    }

    public PrivateProperty getProperty() {
        return property;
    }

    public void setProperty(PrivateProperty property) {
        this.property = property;
    }

    public Boolean getHighlighted() {
        return highlighted;
    }

    public void setHighlighted(Boolean highlighted) {
        this.highlighted = highlighted;
    }
}
