package com.shahyasni.persistence.Entities.PropertyPhotosEntities;


import com.shahyasni.persistence.Entities.PropertyOwnerEntities.Camp;
import com.shahyasni.persistence.Entities.PropertyPhotos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CampPhotos extends PropertyPhotos {

    @ManyToOne
    @JoinColumn(name = "CampID")
    private Camp camp;


    public Camp getCamp() { return camp; }

    public void setCamp(Camp camp) {
        this.camp = camp;
    }
}
