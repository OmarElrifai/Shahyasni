package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.RoomBenefits;

import java.util.List;

public class AccomodationItems {
    private Integer id;
    private String name;
    private Integer PropertyOwnerId;
    private Integer noOfSingleRooms;
    private Integer noOfDoubleRooms;
    private Integer noOfTripleRooms;
    private double singleRoomPrice;
    private double doubleRoomPrice;
    private double tripleRoomPrice;
    private double rating;
    private List<String> benefits;
    private Integer locationId;

    public AccomodationItems(Integer id, String name, Integer PropertyOwnerId, Integer noOfSingleRooms, Integer noOfDoubleRooms, Integer noOfTripleRooms, double singleRoomPrice, double doubleRoomPrice, double tripleRoomPrice, double rating, List<String> benefits, RoomBenefits roomBenefits, Integer locationId){
        this.id = id;
        this.name = name;
        this.PropertyOwnerId = PropertyOwnerId;
        this.noOfSingleRooms = noOfSingleRooms;
        this.noOfDoubleRooms = noOfDoubleRooms;
        this.noOfTripleRooms = noOfTripleRooms;
        this.singleRoomPrice = singleRoomPrice;
        this.doubleRoomPrice = doubleRoomPrice;
        this.tripleRoomPrice = tripleRoomPrice;
        this.rating = rating;
        this.benefits = benefits;
        this.locationId = locationId;
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

    public Integer getPropertyOwnerId() {
        return PropertyOwnerId;
    }

    public void setPropertyOwnerId(Integer propertyOwnerId) {
        PropertyOwnerId = propertyOwnerId;
    }

    public Integer getNoOfSingleRooms() {
        return noOfSingleRooms;
    }

    public void setNoOfSingleRooms(Integer noOfSingleRooms) {
        this.noOfSingleRooms = noOfSingleRooms;
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

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public List<String> getBenefits() {
        return benefits;
    }

    public void setBenefits(List<String> benefits) {
        this.benefits = benefits;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
}
