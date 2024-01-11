package com.shahyasni.persistence;

import com.shahyasni.persistence.DTOs.SearchRequest;
import com.shahyasni.persistence.Enums.FacilitiesChoiceList;

import java.time.LocalDate;

public class test {
    public static void main(String[] arg){
        FacilitiesChoiceList fac = FacilitiesChoiceList.freeWifi;
        System.out.println(fac.getFacilityValue());

    }
}
