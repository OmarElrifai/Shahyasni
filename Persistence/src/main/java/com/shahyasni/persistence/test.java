package com.shahyasni.persistence;

import com.shahyasni.persistence.Enums.FacilitiesChoiceList;

public class test {
    public static void main(String[] arg){
        FacilitiesChoiceList fac = FacilitiesChoiceList.freeWifi;
        System.out.println(fac.getFacilityValue());
    }
}
