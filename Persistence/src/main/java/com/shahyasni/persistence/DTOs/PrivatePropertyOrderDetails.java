package com.shahyasni.persistence.DTOs;

import java.time.LocalDate;
import java.time.LocalTime;

public class PrivatePropertyOrderDetails  extends OrderDetails{
    public PrivatePropertyOrderDetails(Integer id,  String tripDetails, String city, String transportationCompany, LocalDate departureDate, LocalTime departureTime, LocalDate arrivalDate, LocalTime arrivalTime, double dueAmmount) {
        super(id, tripDetails, city, transportationCompany, departureDate, departureTime, arrivalDate, arrivalTime, dueAmmount);

    }

}
