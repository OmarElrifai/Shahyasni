package com.shahyasni.persistence.Entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RoomFacilities {

    @Column(name = "AirCondition")
    private boolean airCondition;

    @Column(name = "PrivateBathroom")
    private boolean privateBathroom;

    @Column(name = "Shower")
    private boolean shower;

    @Column(name = "Fridgerator")
    private boolean fridgerator;

    @Column(name = "BedLinen")
    private boolean bedLinen;

    @Column(name = "Towel")
    private boolean towel;


    public boolean isAirCondition() {
        return airCondition;
    }

    public void setAirCondition(boolean airCondition) {
        this.airCondition = airCondition;
    }

    public boolean isPrivateBathroom() {
        return privateBathroom;
    }

    public boolean isShower() {
        return shower;
    }

    public void setShower(boolean shower) {
        this.shower = shower;
    }

    public boolean isFridgerator() {
        return fridgerator;
    }

    public void setFridgerator(boolean fridgerator) {
        this.fridgerator = fridgerator;
    }

    public boolean isBedLinen() {
        return bedLinen;
    }

    public void setBedLinen(boolean bedLinen) {
        this.bedLinen = bedLinen;
    }

    public boolean isTowel() {
        return towel;
    }

    public void setTowel(boolean towel) {
        this.towel = towel;
    }
}
