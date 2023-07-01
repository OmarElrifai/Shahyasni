package com.shahyasni.persistence.Entities.PropertyOwnerEntities;

import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.PropertyPhotosEntities.CampPhotos;
import com.shahyasni.persistence.Entities.SupportingDocsEntities.CampSupportingDocs;
import com.shahyasni.persistence.Enums.FacilitiesChoiceList;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Entity
public class Camp extends Property{


    @OneToMany(mappedBy = "camp")
    private List<CampSupportingDocs> supportingDocuments;

    @OneToMany(mappedBy = "camp")
    private List<CampPhotos> photos;

    @Column(name = "Price")
    private double price;


    @Embedded
    private Facilities facilities;

    @Embedded
    private RoomFacilities roomFacilities;

    @OneToMany(mappedBy = "camp")
    private List<CampAdditionalFacilities> campAdditionalFacilities;

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

    @Column(name = "RoomService")
    private double roomService;

    @Column(name = "Reception")
    private double reception;

    @Column(name = "FoodQuality")
    private double foodQuality;


    @OneToMany(mappedBy = "campID")
    private List<CampComments> comments;

    public Camp(){

    }



    public List<CampPhotos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<CampPhotos> photos) {
        this.photos = photos;
    }

    public List<CampSupportingDocs> getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(List<CampSupportingDocs> supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public Facilities getFacilities() {
        return facilities;
    }

    public void setFacilities(Facilities facilities) {
        this.facilities = facilities;
    }

    public RoomFacilities getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(RoomFacilities roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public List<CampAdditionalFacilities> getCampAdditionalFacilities() {
        return campAdditionalFacilities;
    }

    public void setCampAdditionalFacilities(List<CampAdditionalFacilities> campAdditionalFacilities) {
        this.campAdditionalFacilities = campAdditionalFacilities;
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


    public List<CampComments> getComments() {
        return comments;
    }

    public void setComments(List<CampComments> comments) {
        this.comments = comments;
    }
}
