package com.shahyasni.persistence.Enums;

public enum RoomFacilitiesChoiceList {
    airCondition("Air Condition")

    ;
    private String fac;
    RoomFacilitiesChoiceList(String fac){
        this.fac = fac;
    }
    public String getFacilityValue(){
        return this.fac;
    }
}
