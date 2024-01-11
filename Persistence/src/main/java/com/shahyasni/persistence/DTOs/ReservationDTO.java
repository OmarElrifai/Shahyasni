package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.ReservationType.LodgingBuildingReservation;
import com.shahyasni.persistence.Entities.ReservationType.PrivatePropertyReservation;
import com.shahyasni.persistence.Entities.User;

import java.time.LocalDate;

public class ReservationDTO {
    private Integer reservationId;
    private Integer noOfSingleRooms;
    private Integer noOfDoubleRooms;
    private Integer noOfTripleRooms;

    private LocalDate fromDate;
    private LocalDate toDate;
    private Integer userId;
    private Integer accomodationId;


    public Integer getNoOfSingleRooms() {
        return noOfSingleRooms;
    }

    public void setNoOfSingleRooms(Integer noOfSingleRooms) {
        this.noOfSingleRooms = noOfSingleRooms;
    }

    public LocalDate getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDate fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate() {
        return toDate;
    }

    public void setToDate(LocalDate toDate) {
        this.toDate = toDate;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAccomodationId() {
        return accomodationId;
    }

    public void setAccomodationId(Integer accomodationId) {
        this.accomodationId = accomodationId;
    }

    public Integer getNoOfDoubleRooms() {
        return noOfDoubleRooms;
    }

    public void setNoOfDoubleRooms(Integer noOfDoubleRooms) {
        this.noOfDoubleRooms = noOfDoubleRooms;
    }

    public Integer getReservationId() {
        return reservationId;
    }

    public void setReservationId(Integer reservationId) {
        this.reservationId = reservationId;
    }

    public LodgingBuildingReservation setLodgingBuildingReservationEntity(LodgingBuildingReservation lodgingBuildingReservation, LodgingBuilding lodgingBuilding, User user){
        lodgingBuildingReservation.setUser(user);
        lodgingBuildingReservation.setNoOfSingleRooms(this.noOfSingleRooms);
        lodgingBuildingReservation.setNoOfDoubleRooms(this.noOfDoubleRooms);
        lodgingBuildingReservation.setNoOfTripleRooms(this.noOfTripleRooms);
        lodgingBuildingReservation.setPrice(this.calculateLodgingReservationPrice(lodgingBuilding));
        lodgingBuildingReservation.setFromDate(this.fromDate);
        lodgingBuildingReservation.setToDate(this.toDate);
        lodgingBuildingReservation.setLodgingBuilding(lodgingBuilding);
        return lodgingBuildingReservation;
    }

    public double calculateLodgingReservationPrice(LodgingBuilding lodgingBuilding){
        double priceOfSingleRooms = this.noOfSingleRooms > 0 ? lodgingBuilding.getSingleRoomPrice() * this.noOfSingleRooms:0;
        double priceOfDoubleRooms = this.noOfDoubleRooms > 0 ? lodgingBuilding.getDoubleRoomsPrice() * this.noOfDoubleRooms:0;
        double priceOfTripleRooms = this.noOfTripleRooms > 0 ? lodgingBuilding.getTripleRoomsPrice() * this.noOfTripleRooms:0;
        return priceOfSingleRooms + priceOfDoubleRooms + priceOfTripleRooms;
    }

    public PrivatePropertyReservation setPrivatePropertyReservationEntity(PrivatePropertyReservation privatePropertyReservation, PrivateProperty privateProperty, User user){
        privatePropertyReservation.setUser(user);
        privatePropertyReservation.setNoOfSingleRooms(this.noOfSingleRooms);
        privatePropertyReservation.setNoOfDoubleRooms(this.noOfDoubleRooms);
        privatePropertyReservation.setNoOfTripleRooms(this.noOfTripleRooms);
        privatePropertyReservation.setPrice(this.calculatePrivateReservationPrice(privateProperty));
        privatePropertyReservation.setFromDate(this.fromDate);
        privatePropertyReservation.setToDate(this.toDate);
        privatePropertyReservation.setPrivateProperty(privateProperty);
        return privatePropertyReservation;
    }

    public double calculatePrivateReservationPrice(PrivateProperty privateProperty){
        double priceOfSingleRooms = this.noOfSingleRooms > 0 ? privateProperty.getSingleRoomPrice() * this.noOfSingleRooms:0;
        double priceOfDoubleRooms = this.noOfDoubleRooms > 0 ? privateProperty.getDoubleRoomsPrice() * this.noOfDoubleRooms:0;
        double priceOfTripleRooms = this.noOfTripleRooms > 0 ? privateProperty.getTripleRoomsPrice() * this.noOfTripleRooms:0;
        return priceOfSingleRooms + priceOfDoubleRooms + priceOfTripleRooms;
    }


    public Integer getNoOfTripleRooms() {
        return noOfTripleRooms;
    }

    public void setNoOfTripleRooms(Integer noOfTripleRooms) {
        this.noOfTripleRooms = noOfTripleRooms;
    }
}