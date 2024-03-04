package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Enums.LodgingBuildingType;
import com.shahyasni.persistence.Enums.PrivatePropertyType;

import java.time.LocalDate;

public class AccomodationsFilter {

    private LocalDate fromDate;
    private LocalDate toDate;
    private LodgingBuildingType lodgingBuildingType;
    private PrivatePropertyType privatePropertyType;
    private Integer noOfSingleRooms;
    private Integer noOfDoubleRooms;
    private Integer noOfTripleRooms;


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

    public LodgingBuildingType getLodgingBuildingType() {
        return lodgingBuildingType;
    }

    public void setLodgingBuildingType(LodgingBuildingType lodgingBuildingType) {
        this.lodgingBuildingType = lodgingBuildingType;
    }

    public PrivatePropertyType getPrivatePropertyType() {
        return privatePropertyType;
    }

    public void setPrivatePropertyType(PrivatePropertyType privatePropertyType) {
        this.privatePropertyType = privatePropertyType;
    }
}
