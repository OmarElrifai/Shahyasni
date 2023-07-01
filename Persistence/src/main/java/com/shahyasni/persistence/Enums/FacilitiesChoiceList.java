package com.shahyasni.persistence.Enums;

public enum FacilitiesChoiceList {
    freeWifi("Free Wifi"),
    parkingLot("Free Parking Lot"),
    airportShuttle("Airport Shuttle"),
    familyRooms("Family Rooms"),
    roomService("Room Service"),
    nonSmokingRooms("Non-smoking-rooms")
    ;

    private String fac;
    FacilitiesChoiceList(String fac) {
        this.fac = fac;
    }

    public String getFacilityValue(){
        return fac;
    }

}
