package com.shahyasni.persistence.Entities.PropertyTypes;

import com.shahyasni.persistence.Entities.CommentsEntities.PrivatePropertyComments;
import com.shahyasni.persistence.Entities.PrivatePropertyFacilities;
import com.shahyasni.persistence.Entities.Property;
import com.shahyasni.persistence.Entities.PropertyOwner;
import com.shahyasni.persistence.Entities.PropertyPhotosEntities.PrivatePropertyPhotos;
import com.shahyasni.persistence.Entities.ReservationType.PrivatePropertyReservation;
import com.shahyasni.persistence.Entities.RoomFacilities;
import com.shahyasni.persistence.Entities.SupportingDocsEntities.PrivatePropertySupportingDocs;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PrivateProperty extends Property{


    @ManyToOne
    @JoinColumn(name = "Owner")
    private PropertyOwner propertyOwner;

    @OneToMany(mappedBy = "privateProperty")
    private List<PrivatePropertySupportingDocs> supportingDocuments = new ArrayList<>();

    @OneToMany(mappedBy = "privateProperty")
    private List<PrivatePropertyPhotos> privatePropertyPhotos = new ArrayList<>();

    @OneToMany(mappedBy = "property")
    private List<PrivatePropertyFacilities> facilities = new ArrayList<>();

    @OneToMany(mappedBy = "property")
    private List<PrivatePropertyComments> comments = new ArrayList<>();

    @OneToMany(mappedBy = "privateProperty")
    private List<PrivatePropertyReservation> reservations = new ArrayList<>();

    @Column(name = "price")
    private double price;

    @Column(name = "Rating")
    private double rating;

    @Embedded
    private RoomFacilities roomFacilities;


    public PrivateProperty(){

    }






    public List<PrivatePropertyPhotos> getIndividualPhotos() {
        return privatePropertyPhotos;
    }

    public void setIndividualPhotos(List<PrivatePropertyPhotos> privatePropertyPhotos) {
        this.privatePropertyPhotos = privatePropertyPhotos;
    }

    public List<PrivatePropertySupportingDocs> getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(List<PrivatePropertySupportingDocs> supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<PrivatePropertyFacilities> getFacilities() {
        return facilities;
    }

    public void setFacilities(List<PrivatePropertyFacilities> facilities) {
        this.facilities = facilities;
    }

    public List<PrivatePropertyComments> getComments() {
        return comments;
    }

    public void setComments(List<PrivatePropertyComments> comments) {
        this.comments = comments;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public List<PrivatePropertyReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<PrivatePropertyReservation> reservations) {
        this.reservations = reservations;
    }
}
