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


}
