package com.shahyasni.persistence.Entities.PropertyPhotosEntities;

import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.PropertyPhotos;

import javax.persistence.*;
import java.sql.Blob;

@Entity
public class PrivatePropertyPhotos extends PropertyPhotos {

    @ManyToOne
    @JoinColumn(name = "PrivateProperty")
    private PrivateProperty privateProperty;

    @Column
    private Boolean coverPhoto;
    @Lob
    @Column(name ="MainPhoto")
    private Blob photo;


    public PrivateProperty getIndividual() { return privateProperty; }

    public void setIndividual(PrivateProperty privateProperty) {
        this.privateProperty = privateProperty;
    }

    public Blob getPhoto() {
        return photo;
    }

    public void setPhoto(Blob photo) {
        this.photo = photo;
    }

    public Boolean getCoverPhoto() {
        return coverPhoto;
    }

    public void setCoverPhoto(Boolean coverPhoto) {
        this.coverPhoto = coverPhoto;
    }
}
