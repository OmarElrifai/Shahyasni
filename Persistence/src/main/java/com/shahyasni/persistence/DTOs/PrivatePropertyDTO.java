package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;

import java.beans.ConstructorProperties;

public class PrivatePropertyDTO {


    private Integer id;
    private Integer PropertyOwnerId;
    private Integer noOfSingleRooms;
    private Integer noOfDoubleRooms;
    private Integer noOfTripleRooms;
    private double singleRoomPrice;
    private double doubleRoomPrice;
    private double tripleRoomPrice;
    private double rating;
    private String buildingType;
    private RoomFacilities roomFacilities;
    private Integer locationId;
    private Address address;

    @ConstructorProperties({"buildingType","address","singleRoomPrice","doubleRoomPrice","tripleRoomPrice","noOfSingleRooms","noOfDoubleRooms","noOfTripleRooms","rating",})
    public PrivatePropertyDTO(String buildingType, Address address, double singleRoomPrice, double doubleRoomPrice, double tripleRoomPrice, Integer noOfSingleRooms, Integer noOfDoubleRooms,  Integer noOfTripleRooms, double rating){

        this.buildingType = buildingType;
        this.address = address;
        this.noOfSingleRooms = noOfSingleRooms;
        this.noOfDoubleRooms = noOfDoubleRooms;
        this.noOfTripleRooms = noOfTripleRooms;
        this.singleRoomPrice = singleRoomPrice;
        this.doubleRoomPrice = doubleRoomPrice;
        this.tripleRoomPrice = tripleRoomPrice;
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

    public String getBuildingType() {
        return buildingType;
    }

    public void setBuildingType(String buildingType) {
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
        return PropertyOwnerId;
    }

    public void setPropertyOwnerId(Integer propertyOwnerId) {
        PropertyOwnerId = propertyOwnerId;
    }

    public RoomFacilities getRoomFacilities() {
        return roomFacilities;
    }

    public void setRoomFacilities(RoomFacilities roomFacilities) {
        this.roomFacilities = roomFacilities;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }

    public PrivateProperty toPrivatePropertyEntity(PrivateProperty privateProperty, Owner owner, Location location){
        privateProperty.setPropertyOwner(owner);
        privateProperty.setSingleRoomPrice(this.singleRoomPrice);
        privateProperty.setDoubleRoomsPrice(this.doubleRoomPrice);
        privateProperty.setTripleRoomsPrice(this.tripleRoomPrice);
        privateProperty.setRating(this.rating);
        privateProperty.setBuildingType(this.buildingType);
        privateProperty.setSingleRoomsMax(this.noOfSingleRooms);
        privateProperty.setDoubleRoomsMax(this.noOfDoubleRooms);
        privateProperty.setTripleRoomsMax(this.noOfTripleRooms);
        privateProperty.setRoomFacilities(this.roomFacilities);
        privateProperty.setLocation(location);
        privateProperty.setAddress(this.address);
        return privateProperty;
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
}
