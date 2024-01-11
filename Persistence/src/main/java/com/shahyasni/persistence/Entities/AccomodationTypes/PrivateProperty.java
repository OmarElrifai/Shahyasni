package com.shahyasni.persistence.Entities.AccomodationTypes;

import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.CommentsEntities.PrivatePropertyComments;
import com.shahyasni.persistence.Entities.PrivatePropertyFacilities;
import com.shahyasni.persistence.Entities.Owner;
import com.shahyasni.persistence.Entities.PropertyPhotosEntities.PrivatePropertyPhotos;
import com.shahyasni.persistence.Entities.ReservationType.PrivatePropertyReservation;
import com.shahyasni.persistence.Entities.RoomFacilities;
import com.shahyasni.persistence.Entities.SupportingDocsEntities.PrivatePropertySupportingDocs;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class PrivateProperty{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "Owner")
    private Owner owner;

    @OneToMany(mappedBy = "privateProperty")
    @JsonbTransient
    private List<PrivatePropertySupportingDocs> supportingDocuments = new ArrayList<>();

    @OneToMany(mappedBy = "privateProperty")
    @JsonbTransient
    private List<PrivatePropertyPhotos> privatePropertyPhotos = new ArrayList<>();

    @OneToMany(mappedBy = "property")
    @JsonbTransient
    private List<PrivatePropertyFacilities> facilities = new ArrayList<>();

    @OneToMany(mappedBy = "property")
    @JsonbTransient
    private List<PrivatePropertyComments> comments = new ArrayList<>();

    @OneToMany(mappedBy = "privateProperty")
    @JsonbTransient
    private List<PrivatePropertyReservation> reservations = new ArrayList<>();


    @Column(name = "Rating")
    private double rating;

    @Column(name = "BuildingType")
    private String buildingType;

    @Column(name = "SingleRoomsMax")
    private Integer singleRoomsMax;

    @Column(name = "singleRoomPrice")
    private double singleRoomPrice;
    @Column(name = "DoubleRoomsMax")
    private Integer doubleRoomsMax;

    @Column(name = "DoubleRoomsPrice")
    private double doubleRoomsPrice;

    @Column(name = "TripleRoomsMax")
    private Integer tripleRoomsMax;

    @Column(name = "TripleRoomsPrice")
    private double tripleRoomsPrice;


    @Embedded
    private RoomFacilities roomFacilities;

    @ManyToOne
    @JoinColumn(name = "Location")
    private Location location;

    @Embedded
    private Address address;

    public PrivateProperty(){

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

    public List<PrivatePropertyReservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<PrivatePropertyReservation> reservations) {
        this.reservations = reservations;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public RoomFacilities getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(RoomFacilities roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public List<PrivatePropertyPhotos> getPrivatePropertyPhotos() {
        return privatePropertyPhotos;
    }

    public void setPrivatePropertyPhotos(List<PrivatePropertyPhotos> privatePropertyPhotos) {
        this.privatePropertyPhotos = privatePropertyPhotos;
    }

    public Owner getPropertyOwner() {
        return owner;
    }

    public void setPropertyOwner(Owner owner) {
        this.owner = owner;
    }

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
        this.buildingType = buildingType;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSingleRoomsMax() {
        return singleRoomsMax;
    }

    public void setSingleRoomsMax(Integer singleRoomsMax) {
        this.singleRoomsMax = singleRoomsMax;
    }

    public double getSingleRoomPrice() {
        return singleRoomPrice;
    }

    public void setSingleRoomPrice(double singleRoomPrice) {
        this.singleRoomPrice = singleRoomPrice;
    }

    public Integer getDoubleRoomsMax() {
        return doubleRoomsMax;
    }

    public void setDoubleRoomsMax(Integer doubleRoomsMax) {
        this.doubleRoomsMax = doubleRoomsMax;
    }

    public double getDoubleRoomsPrice() {
        return doubleRoomsPrice;
    }

    public void setDoubleRoomsPrice(double doubleRoomsPrice) {
        this.doubleRoomsPrice = doubleRoomsPrice;
    }

    public Integer getTripleRoomsMax() {
        return tripleRoomsMax;
    }

    public void setTripleRoomsMax(Integer tripleRoomsMax) {
        this.tripleRoomsMax = tripleRoomsMax;
    }

    public double getTripleRoomsPrice() {
        return tripleRoomsPrice;
    }

    public void setTripleRoomsPrice(double tripleRoomsPrice) {
        this.tripleRoomsPrice = tripleRoomsPrice;
    }
}
