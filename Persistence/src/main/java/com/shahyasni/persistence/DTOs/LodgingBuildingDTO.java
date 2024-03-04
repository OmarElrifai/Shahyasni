package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Enums.LodgingBuildingType;

import java.beans.ConstructorProperties;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LodgingBuildingDTO {

    private Integer id;
    private String name;
    private Address address;

    private Integer ownerId;
    private double singleRoomPrice;
    private double doubleRoomPrice;
    private double tripleRoomPrice;
    private LodgingBuildingType lodgingBuildingType;
    private List<LodgingBuildingBenefits> lodgingBuildingBenefits;
    private RoomBenefits roomBenefits;
    private LocalTime checkout;
    private Integer singleRoomsMax;
    private Integer doubleRoomsMax;
    private Integer tripleRoomsMax;
    private String hotelDescription;
    private double cleanliness;
    private double roomService;
    private double reception;
    private double foodQuality;
    private Integer locationId;
    private LodgingBuildingBenefits benefits;
    private Location location;

    private Comments comments;

    @ConstructorProperties({"id","name","address","singleRoomPrice","doubleRoomPrice","tripleRoomPrice","lodgingBuildingType","hotelDescription","cleanliness","roomService","reception","foodQuality","benefits","ownerId","comments","location"})
    public LodgingBuildingDTO(Integer id,String name, Address address,double singleRoomPrice, double doubleRoomPrice,double tripleRoomPrice, LodgingBuildingType lodgingBuildingType, String hotelDescription, double cleanliness, double roomService, double reception, double foodQuality,LodgingBuildingBenefits benefits, Integer ownerId,Comments comments,Location location ){
    this.id = id;
    this.name = name;
    this.address = address;
    this.singleRoomPrice = singleRoomPrice;
    this.doubleRoomPrice = doubleRoomPrice;
    this.tripleRoomPrice = tripleRoomPrice;
    this.lodgingBuildingType = lodgingBuildingType;
    this.hotelDescription = hotelDescription;
    this.cleanliness = cleanliness;
    this.roomService = roomService;
    this.reception = reception;
    this.foodQuality = foodQuality;
    this.benefits = benefits;
    this.ownerId = ownerId;
    this.comments = comments;
    this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public LodgingBuildingType getLodgingBuildingType() {
        return lodgingBuildingType;
    }

    public void setLodgingBuildingType(LodgingBuildingType lodgingBuildingType) {
        this.lodgingBuildingType = lodgingBuildingType;
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

    public List<LodgingBuildingBenefits> getLodgingBuildingBenefits() {
        return lodgingBuildingBenefits;
    }

    public void setLodgingBuildingBenefits(List<LodgingBuildingBenefits> lodgingBuildingBenefits) {
        this.lodgingBuildingBenefits = lodgingBuildingBenefits;
    }

    public RoomBenefits getRoomBenefits() {
        return roomBenefits;
    }

    public void setRoomBenefits(RoomBenefits roomBenefits) {
        this.roomBenefits = roomBenefits;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }



    public LodgingBuilding toLodgingBuildingEntity(LodgingBuilding lodgingBuilding, Location location,Owner owner){
        lodgingBuilding.setName(this.name);
        lodgingBuilding.setSingleRoomPrice(this.singleRoomPrice);
        lodgingBuilding.setDoubleRoomsPrice(this.doubleRoomPrice);
        lodgingBuilding.setTripleRoomsPrice(this.tripleRoomPrice);
        lodgingBuilding.setLodgingBuildingType(this.lodgingBuildingType);
        lodgingBuilding.setCheckout(this.checkout);
        lodgingBuilding.setSingleRoomsMax(this.singleRoomsMax);
        lodgingBuilding.setDoubleRoomsMax(this.doubleRoomsMax);
        lodgingBuilding.setTripleRoomsMax(this.tripleRoomsMax);
        lodgingBuilding.setHotelDescription(this.hotelDescription);
        lodgingBuilding.setCleanliness(this.cleanliness);
        lodgingBuilding.setRoomService(this.roomService);
        lodgingBuilding.setReception(this.reception);
        lodgingBuilding.setFoodQuality(this.foodQuality);
        lodgingBuilding.setLocation(location);
        lodgingBuilding.setOwner(owner);
        lodgingBuilding.setAddress(address);
        return lodgingBuilding;
    }

    public List<LodgingBuildingBenefits> createLodgingBuildingBenefitsEntities(LodgingBuilding lodgingBuilding){
        List<LodgingBuildingBenefits> lodgingBuildingBenefitsEntities = new ArrayList<>();
        for (LodgingBuildingBenefits lodgingBuildingBenefit : this.lodgingBuildingBenefits) {
            LodgingBuildingBenefits benefitEntity = new LodgingBuildingBenefits();
            benefitEntity.setBenefitType(lodgingBuildingBenefit.getBenefitType());
            benefitEntity.setBenefit(lodgingBuildingBenefit.getBenefit());
            benefitEntity.setLodgingBuilding(lodgingBuilding);
            lodgingBuildingBenefitsEntities.add(benefitEntity);
        }
        return lodgingBuildingBenefitsEntities;
    }

    public double getSingleRoomPrice() {
        return singleRoomPrice;
    }

    public void setSingleRoomPrice(double singleRoomPrice) {
        this.singleRoomPrice = singleRoomPrice;
    }

    public double getDoubleRoomPrice() {
        return doubleRoomPrice;
    }

    public void setDoubleRoomPrice(double doubleRoomPrice) {
        this.doubleRoomPrice = doubleRoomPrice;
    }

    public double getTripleRoomPrice() {
        return tripleRoomPrice;
    }

    public void setTripleRoomPrice(double tripleRoomPrice) {
        this.tripleRoomPrice = tripleRoomPrice;
    }

    public LodgingBuildingBenefits getBenefits() {
        return benefits;
    }

    public void setBenefits(LodgingBuildingBenefits benefits) {
        this.benefits = benefits;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Comments getComments() {
        return comments;
    }

    public void setComments(Comments comments) {
        this.comments = comments;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
