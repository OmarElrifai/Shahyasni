package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.CommentsEntities.PrivatePropertyComments;
import com.shahyasni.persistence.Enums.PrivatePropertyType;

import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.List;

public class PrivatePropertyDTO {


    private Integer id;
    private String name;
    private Integer ownerId;
    private Integer propertyOwnerId;
    private Integer singleRoomsMax;
    private Integer doubleRoomsMax;
    private Integer tripleRoomsMax;
    private double singleRoomPrice;
    private double doubleRoomPrice;
    private double tripleRoomPrice;
    private double rating;
    private PrivatePropertyType buildingType;
    private PrivatePropertyBenefits benefits;
    private List<PrivatePropertyBenefits> privatePropertyBenefits;
    private RoomBenefits roomBenefits;
    private Location location;
    private Integer locationId;
    private Address address;
    private PrivatePropertyComments comments;


    @ConstructorProperties({"id","name","buildingType","location","address","singleRoomPrice","doubleRoomPrice","tripleRoomPrice","benefits","rating","comments","ownerId"})
    public PrivatePropertyDTO(Integer id, String name, PrivatePropertyType buildingType, Location location, Address address, double singleRoomPrice, double doubleRoomPrice, double tripleRoomPrice, PrivatePropertyBenefits privatePropertyBenefits, double rating, PrivatePropertyComments comments, Integer ownerId){
        this.id = id;
        this.name = name;
        this.location = location;
        this.address = address;
        this.singleRoomPrice = singleRoomPrice;
        this.doubleRoomPrice = doubleRoomPrice;
        this.tripleRoomPrice = tripleRoomPrice;
        this.benefits = privatePropertyBenefits;
        this.rating = rating;
        this.comments = comments;
        this.ownerId = ownerId;
        this.buildingType = buildingType;
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

    public Integer getSingleRoomsMax() {
        return singleRoomsMax;
    }

    public void setSingleRoomsMax(Integer singleRoomsMax) {
        this.singleRoomsMax = singleRoomsMax;
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

    public RoomBenefits getRoomBenefits() {
        return roomBenefits;
    }

    public void setRoomBenefits(RoomBenefits roomBenefits) {
        this.roomBenefits = roomBenefits;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<PrivatePropertyBenefits> getPrivatePropertyBenefits(){
        return this.privatePropertyBenefits;
    }
    public void setPrivatePropertyBenefits(List<PrivatePropertyBenefits> privatePropertyBenefits) {
        this.privatePropertyBenefits = privatePropertyBenefits;
    }
    public PrivateProperty toPrivatePropertyEntity(PrivateProperty privateProperty, Owner owner, Location location){
        privateProperty.setName(this.name);
        privateProperty.setPropertyOwner(owner);
        privateProperty.setPrivatePropertyType(this.buildingType);
        privateProperty.setSingleRoomPrice(this.singleRoomPrice);
        privateProperty.setDoubleRoomsPrice(this.doubleRoomPrice);
        privateProperty.setTripleRoomsPrice(this.tripleRoomPrice);
        privateProperty.setRating(this.rating);
        privateProperty.setSingleRoomsMax(this.singleRoomsMax);
        privateProperty.setDoubleRoomsMax(this.doubleRoomsMax);
        privateProperty.setTripleRoomsMax(this.tripleRoomsMax);
        privateProperty.setLocation(location);
        privateProperty.setAddress(this.address);
        return privateProperty;
    }


    public List<PrivatePropertyBenefits> createPrivatePropertyBenefitsEntities(PrivateProperty privateProperty){
        List<PrivatePropertyBenefits> privatePropertyBenefitsEntities = new ArrayList<>();
        for (PrivatePropertyBenefits privatePropertyBenefits : this.getPrivatePropertyBenefits()) {
            PrivatePropertyBenefits benefitEntity = new PrivatePropertyBenefits();
            benefitEntity.setBenefitType(privatePropertyBenefits.getBenefitType());
            benefitEntity.setBenefit(privatePropertyBenefits.getBenefit());
            benefitEntity.setProperty(privateProperty);
            privatePropertyBenefitsEntities.add(benefitEntity);
        }
        return privatePropertyBenefitsEntities;
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

    public PrivatePropertyComments getComments() {
        return comments;
    }

    public void setComments(PrivatePropertyComments comments) {
        this.comments = comments;
    }

    public PrivatePropertyBenefits getBenefits() {
        return benefits;
    }

    public void setBenefits(PrivatePropertyBenefits benefits) {
        this.benefits = benefits;
    }

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer locationId) {
        this.locationId = locationId;
    }
}
