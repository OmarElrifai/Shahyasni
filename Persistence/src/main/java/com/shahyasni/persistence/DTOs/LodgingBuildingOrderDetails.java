package com.shahyasni.persistence.DTOs;

import java.time.LocalDate;
import java.time.LocalTime;

public class LodgingBuildingOrderDetails extends OrderDetails{

    private String lodgingBuildingName;
    public LodgingBuildingOrderDetails(Integer id, String username, String tripDetails, String city, String transportationCompany, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, double dueAmmount, String lodgingBuildingName) {
        super(id,username, tripDetails, city, transportationCompany, departureDate, departureTime, arrivalDate, arrivalTime, dueAmmount);
        this.lodgingBuildingName = lodgingBuildingName;
    }

    public String getLodgingBuildingName() {
        return lodgingBuildingName;
    }


    public void setLodgingBuildingName(String lodgingBuildingName) {
        this.lodgingBuildingName = lodgingBuildingName;
    }
}
