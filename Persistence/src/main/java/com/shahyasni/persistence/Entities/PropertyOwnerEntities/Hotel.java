package com.shahyasni.persistence.Entities.PropertyOwnerEntities;

import com.shahyasni.persistence.Entities.Property;
import com.shahyasni.persistence.Entities.PropertyPhotosEntities.HotelPhotos;
import com.shahyasni.persistence.Entities.SupportingDocsEntities.HotelSupportingDocs;

import javax.persistence.*;
import java.util.List;

@Entity
public class Hotel extends Property {


    @OneToMany(mappedBy = "hotel")
    private List<HotelSupportingDocs> supportingDocuments;

    @OneToMany(mappedBy = "hotel")
    private List<HotelPhotos> photos;


    public Hotel(){

    }

    public List<HotelPhotos> getPhotos() { return photos; }

    public void setPhotos(List<HotelPhotos> photos) {
        this.photos = photos;
    }

    public List<HotelSupportingDocs> getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(List<HotelSupportingDocs> supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }
}
