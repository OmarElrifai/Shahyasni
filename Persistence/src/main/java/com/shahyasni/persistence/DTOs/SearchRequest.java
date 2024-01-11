package com.shahyasni.persistence.DTOs;

import java.time.LocalDate;
import java.util.Date;
import java.util.zip.DataFormatException;

public class SearchRequest {
    private LocalDate from;
    private LocalDate to;
    private Integer id;
    private String city;
    private String sight;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
}
