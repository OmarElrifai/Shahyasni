package com.shahyasni.persistence.Entities.PropertyPhotosEntities;

import com.shahyasni.persistence.Entities.PropertyOwnerEntities.PrivateProperty;
import com.shahyasni.persistence.Entities.PropertyPhotos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class IndividualPhotos extends PropertyPhotos {

    @ManyToOne
    @JoinColumn(name = "IndividualID")
    private PrivateProperty privateProperty;


    public PrivateProperty getIndividual() { return privateProperty; }

    public void setIndividual(PrivateProperty privateProperty) {
        this.privateProperty = privateProperty;
    }
}
