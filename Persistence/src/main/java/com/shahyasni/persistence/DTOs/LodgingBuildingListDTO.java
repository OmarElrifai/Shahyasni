package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Enums.LodgingBuildingType;

import java.beans.ConstructorProperties;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class LodgingBuildingListDTO {

    private Integer id;
    private String name;
    private Address address;
    private double singleRoomPrice;
    private double doubleRoomPrice;
    private double tripleRoomPrice;
    private LodgingBuildingType lodgingBuildingType;

    private String hotelDescription;

    private LodgingBuildingBenefits benefits;
    private Location location;

    private double rating;

    @ConstructorProperties({"id","name","address","singleRoomPrice","doubleRoomPrice","tripleRoomPrice","lodgingBuildingType","hotelDescription","benefits","location","rating"})
    public LodgingBuildingListDTO(Integer id, String name, Address address, double singleRoomPrice, double doubleRoomPrice, double tripleRoomPrice, LodgingBuildingType lodgingBuildingType, String hotelDescription, LodgingBuildingBenefits benefits, Location location, double rating ){
    this.id = id;
    this.name = name;
    this.address = address;
    this.singleRoomPrice = singleRoomPrice;
    this.doubleRoomPrice = doubleRoomPrice;
    this.tripleRoomPrice = tripleRoomPrice;
    this.lodgingBuildingType = lodgingBuildingType;
    this.hotelDescription = hotelDescription;
    this.benefits = benefits;
    this.location = location;
    this.rating = rating;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
