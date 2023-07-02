package com.shahyasni.persistence.Entities.PropertyTypes;

import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.CommentsEntities.LodgingBuildingComments;
import com.shahyasni.persistence.Entities.PropertyPhotosEntities.LodgingBuildingPhotos;
import com.shahyasni.persistence.Entities.ReservationType.LodgingBuildingReservation;
import com.shahyasni.persistence.Entities.SupportingDocsEntities.LodgingBuildingDocs;
import com.shahyasni.persistence.Enums.LodgingBuildingType;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LodgingBuilding extends Property{


    @OneToMany(mappedBy = "lodgingBuilding")
    private List<LodgingBuildingDocs> supportingDocuments = new ArrayList<>();

    @OneToMany(mappedBy = "lodgingBuilding")
    private List<LodgingBuildingPhotos> photos = new ArrayList<>();

    @Column(name = "Price")
    private double price;

    @Column(name = "LodgingBuildingType")
    private LodgingBuildingType lodgingBuildingType;

    @OneToMany(mappedBy = "lodgingBuilding")
    private List<LodgingBuildingReservation> lodgingBuildingReservations = new ArrayList<>();

    @Embedded
    private LodgingBuildingFacilities lodgingBuildingFacilities;

    @Embedded
    private RoomFacilities roomFacilities;

    @OneToMany(mappedBy = "lodgingBuilding")
    private List<LodgingBuildingAdditionalFacilities> lodgingBuildingAdditionalFacilities = new ArrayList<>();

    @Column(name = "CheckoutTime")
    private LocalTime checkout;

    @Column(name = "SingleRoomsMax")
    private Integer singleRoomsMax;

    @Column(name = "DoubleRoomsMax")
    private Integer doubleRoomsMax;

    @Column(name = "TripleRoomsMax")
    private Integer tripleRoomsMax;

    @Column(name = "HotelDescription")
    private String hotelDescription;

    @Column(name = "Cleanliness")
    private double cleanliness;

    @Column(name = "RoomServiceEvaluation")
    private double roomService;

    @Column(name = "ReceptionDecency")
    private double reception;

    @Column(name = "FoodQuality")
    private double foodQuality;

    @OneToMany(mappedBy = "lodgingBuilding")
    private List<LodgingBuildingComments> comments = new ArrayList<>();

    public LodgingBuilding(){

    }



    public List<LodgingBuildingPhotos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<LodgingBuildingPhotos> photos) {
        this.photos = photos;
    }

    public List<LodgingBuildingDocs> getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(List<LodgingBuildingDocs> supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public LodgingBuildingFacilities getFacilities() {
        return lodgingBuildingFacilities;
    }

    public void setFacilities(LodgingBuildingFacilities lodgingBuildingFacilities) {
        this.lodgingBuildingFacilities = lodgingBuildingFacilities;
    }

    public RoomFacilities getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(RoomFacilities roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public List<LodgingBuildingAdditionalFacilities> getCampAdditionalFacilities() {
        return lodgingBuildingAdditionalFacilities;
    }

    public void setCampAdditionalFacilities(List<LodgingBuildingAdditionalFacilities> lodgingBuildingAdditionalFacilities) {
        this.lodgingBuildingAdditionalFacilities = lodgingBuildingAdditionalFacilities;
    }

    public LocalTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalTime checkout) {
        this.checkout = checkout;
    }

    public Integer getSingleRoomsMax() {
        return singleRoomsMax;
    }

    public void setSingleRoomsMax(Integer singleRoomsMax) {
        this.singleRoomsMax = singleRoomsMax;
    }

    public Integer getDoubleRoomsMax() {
        return doubleRoomsMax;
    }

    public void setDoubleRoomsMax(Integer doubleRoomsMax) {
        this.doubleRoomsMax = doubleRoomsMax;
    }

    public Integer getTripleRoomsMax() {
        return tripleRoomsMax;
    }

    public void setTripleRoomsMax(Integer tripleRoomsMax) {
        this.tripleRoomsMax = tripleRoomsMax;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    public double getRoomService() {
        return roomService;
    }

    public void setRoomService(double roomService) {
        this.roomService = roomService;
    }

    public double getReception() {
        return reception;
    }

    public void setReception(double reception) {
        this.reception = reception;
    }

    public double getFoodQuality() {
        return foodQuality;
    }

    public void setFoodQuality(double foodQuality) {
        this.foodQuality = foodQuality;
    }


    public List<LodgingBuildingComments> getComments() {
        return comments;
    }

    public void setComments(List<LodgingBuildingComments> comments) {
        this.comments = comments;
    }

    public LodgingBuildingType getLodgingBuildingType() {
        return lodgingBuildingType;
    }

    public void setLodgingBuildingType(LodgingBuildingType lodgingBuildingType) {
        this.lodgingBuildingType = lodgingBuildingType;
    }

    public List<LodgingBuildingReservation> getLodgingBuildingReservations() {
        return lodgingBuildingReservations;
    }

    public void setLodgingBuildingReservations(List<LodgingBuildingReservation> lodgingBuildingReservations) {
        this.lodgingBuildingReservations = lodgingBuildingReservations;
    }
}
