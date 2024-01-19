package com.shahyasni.persistence.Enums;

public enum BenefitType {
    publicFacility("Public Facility"),
    roomFacility("Room Facility"),
    advantage("Advantage");

    private String facilityType;
    BenefitType(String facilityType){
        this.facilityType = facilityType;
    }

    public String getFacilityType() {
        return facilityType;
    }
}
