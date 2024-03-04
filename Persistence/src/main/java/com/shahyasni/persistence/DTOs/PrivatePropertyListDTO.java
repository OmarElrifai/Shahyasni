package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.CommentsEntities.PrivatePropertyComments;
import com.shahyasni.persistence.Enums.PrivatePropertyType;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

public class PrivatePropertyListDTO {


    private Integer id;
    private String name;
    private Integer ownerId;
    private Integer propertyOwnerId;
    private Integer noOfSingleRooms;
    private Integer noOfDoubleRooms;
    private Integer noOfTripleRooms;
    private double singleRoomPrice;
    private double doubleRoomPrice;
    private double tripleRoomPrice;
    private double rating;
    private PrivatePropertyType buildingType;
    private PrivatePropertyBenefits benefits;

    private Location location;
    private Address address;


    @ConstructorProperties({"id","name","type","location","address","singleRoomPrice","doubleRoomPrice","tripleRoomPrice","benefits","rating"})
    public PrivatePropertyListDTO(Integer id, String name,PrivatePropertyType type, Location location, Address address, double singleRoomPrice, double doubleRoomPrice, double tripleRoomPrice, PrivatePropertyBenefits privatePropertyBenefits, double rating){
        this.id = id;
        this.name = name;
        this.location = location;
        this.address = address;
        this.singleRoomPrice = singleRoomPrice;
        this.doubleRoomPrice = doubleRoomPrice;
        this.tripleRoomPrice = tripleRoomPrice;
        this.benefits = privatePropertyBenefits;
        this.buildingType = type;
        this.rating = rating;
    }

    public double getSingleRoomPrice() {
        return singleRoomPrice;
    }

    public void setSingleRoomPrice(double singleRoomPrice) {
        this.singleRoomPrice = singleRoomPrice;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public PrivatePropertyType getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(PrivatePropertyType buildingType) {
        this.buildingType = buildingType;
    }

    public Integer getNoOfSingleRooms() {
        return noOfSingleRooms;
    }

    public void setNoOfSingleRooms(Integer noOfSingleRooms) {
        this.noOfSingleRooms = noOfSingleRooms;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getPropertyOwnerId() {
        return propertyOwnerId;
    }

    public void setPropertyOwnerId(Integer propertyOwnerId) {
        this.propertyOwnerId = propertyOwnerId;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoOfDoubleRooms() {
        return noOfDoubleRooms;
    }

    public void setNoOfDoubleRooms(Integer noOfDoubleRooms) {
        this.noOfDoubleRooms = noOfDoubleRooms;
    }

    public Integer getNoOfTripleRooms() {
        return noOfTripleRooms;
    }

    public void setNoOfTripleRooms(Integer noOfTripleRooms) {
        this.noOfTripleRooms = noOfTripleRooms;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



    public PrivatePropertyBenefits getBenefits() {
        return benefits;
    }

    public void setBenefits(PrivatePropertyBenefits benefits) {
        this.benefits = benefits;
    }




}
