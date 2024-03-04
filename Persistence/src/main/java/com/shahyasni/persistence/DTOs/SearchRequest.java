package com.shahyasni.persistence.DTOs;

import java.time.LocalDate;

public class SearchRequest {
    private LocalDate from;
    private LocalDate to;

    private Integer userId;
    private Integer noOfSingleRooms;
    private Integer noOfDoubleRooms;
    private Integer noOfTripleRooms;
    private Integer accomodationId;

    private String city;
    private String sight;



    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSight() {
        return sight;
    }

    public void setSight(String sight) {
        this.sight = sight;
    }

    public Integer getAccomodationId() {
        return accomodationId;
    }

    public void setAccomodationId(Integer accomodationId) {
        this.accomodationId = accomodationId;
    }

    public Integer getNoOfSingleRooms() {
        return noOfSingleRooms;
    }

    public void setNoOfSingleRooms(Integer noOfSingleRooms) {
        this.noOfSingleRooms = noOfSingleRooms;
    }

    public Integer getNoOfDoubleRooms() {
        return noOfDoubleRooms;
    }

    public void setNoOfDoubleRooms(Integer noOfDoubleRooms) {
        this.noOfDoubleRooms = noOfDoubleRooms;
    }

    public Integer getNoOfTripleRooms() {
        return noOfTripleRooms;
    }

    public void setNoOfTripleRooms(Integer noOfTripleRooms) {
        this.noOfTripleRooms = noOfTripleRooms;
    }
}
