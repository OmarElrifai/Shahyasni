package com.shahyasni.persistence.Enums;

public enum PrivatePropertyType {
    villa("Villa"),
    twinHouse("Twin House"),
    townHouse("Town House"),
    apartments("Apartment"),
    studio("Studio");


    private String privatePropertyType;
    PrivatePropertyType(String privatePropertyType){
        this.privatePropertyType = privatePropertyType;
    }

    public String getFacilityType() {
        return privatePropertyType;
    }
}
