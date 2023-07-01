package com.shahyasni.persistence.Entities.PropertyPhotosEntities;

import com.shahyasni.persistence.Entities.PropertyOwnerEntities.Hotel;
import com.shahyasni.persistence.Entities.PropertyPhotos;

import javax.persistence.*;

@Entity
public class HotelPhotos extends PropertyPhotos {



    @ManyToOne
    @JoinColumn(name = "HotelID")
    private Hotel hotel;



    public Hotel getHotel() { return hotel; }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

}
