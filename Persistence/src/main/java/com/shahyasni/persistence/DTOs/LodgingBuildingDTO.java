package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Enums.LodgingBuildingType;

import java.beans.ConstructorProperties;
import java.time.LocalTime;

public class LodgingBuildingDTO {

    private Integer id;
    private String name;
    private Address address;

    private double singleRoomPrice;
    private double doubleRoomPrice;
    private double tripleRoomPrice;
    private LodgingBuildingType lodgingBuildingType;
    private  LodgingBuildingFacilities lodgingBuildingFacilities;
    private RoomFacilities roomFacilities;
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

    @ConstructorProperties({"name","address","singleRoomPrice","doubleRoomPrice","tripleRoomPrice","lodgingBuildingType","hotelDescription","cleanliness","roomService","reception","foodQuality"})
    public LodgingBuildingDTO(String name, Address address,double singleRoomPrice, double doubleRoomPrice,double tripleRoomPrice, LodgingBuildingType lodgingBuildingType, String hotelDescription, double cleanliness, double roomService, double reception, double foodQuality){
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

    public LodgingBuildingFacilities getLodgingBuildingFacilities() {
        return lodgingBuildingFacilities;
    }

    public void setLodgingBuildingFacilities(LodgingBuildingFacilities lodgingBuildingFacilities) {
        this.lodgingBuildingFacilities = lodgingBuildingFacilities;
    }

    public RoomFacilities getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(RoomFacilities roomFacilities) {
        this.roomFacilities = roomFacilities;
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



    public LodgingBuilding toLodgingBuildingEntity(LodgingBuilding lodgingBuilding, Location location){
        lodgingBuilding.setName(this.name);
        lodgingBuilding.setSingleRoomPrice(this.singleRoomPrice);
        lodgingBuilding.setDoubleRoomsPrice(this.doubleRoomPrice);
        lodgingBuilding.setTripleRoomsPrice(this.tripleRoomPrice);
        lodgingBuilding.setLodgingBuildingType(this.lodgingBuildingType);
        lodgingBuilding.setLodgingBuildingFacilities(this.lodgingBuildingFacilities);
        lodgingBuilding.setRoomFacilities(this.roomFacilities);
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
        lodgingBuilding.setAddress(address);
        return lodgingBuilding;
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
}
