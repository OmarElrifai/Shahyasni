package com.shahyasni.persistence.Entities.PropertyPhotosEntities;

import com.shahyasni.persistence.Entities.PropertyTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.PropertyPhotos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PrivatePropertyPhotos extends PropertyPhotos {

    @ManyToOne
    @JoinColumn(name = "PrivateProperty")
    private PrivateProperty privateProperty;


    public PrivateProperty getIndividual() { return privateProperty; }

    public void setIndividual(PrivateProperty privateProperty) {
        this.privateProperty = privateProperty;
    }
}
