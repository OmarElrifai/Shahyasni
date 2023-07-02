package com.shahyasni.persistence.Entities.PropertyPhotosEntities;


import com.shahyasni.persistence.Entities.PropertyTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.PropertyPhotos;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LodgingBuildingPhotos extends PropertyPhotos {



    @ManyToOne
    @JoinColumn(name = "LodgingBuildingID")
    private LodgingBuilding lodgingBuilding;



    public LodgingBuilding getCamp() { return lodgingBuilding; }

    public void setCamp(LodgingBuilding lodgingBuilding) {
        this.lodgingBuilding = lodgingBuilding;
    }


}
