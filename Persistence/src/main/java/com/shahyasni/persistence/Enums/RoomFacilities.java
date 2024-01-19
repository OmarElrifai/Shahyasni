package com.shahyasni.persistence.Enums;

public enum RoomFacilities {
    airCondition("Air Condition"),

    privateBathroom("Private Bathroom"),

    shower("Shower"),

    fridgerator("Fridgerator"),

    bedLinen("BedLinen"),

    towel("Towel");


    private String fac;
    RoomFacilities(String fac){
        this.fac = fac;
    }
    public String getFacilityValue(){
        return this.fac;
    }
}
