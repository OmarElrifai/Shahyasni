package com.shahyasni.persistence.Entities.SupportingDocsEntities;

import com.shahyasni.persistence.Entities.PropertyTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.SupportingDocs;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class LodgingBuildingDocs extends SupportingDocs {



    @ManyToOne
    @JoinColumn(name = "LodgingBuildingID")
    private LodgingBuilding lodgingBuilding;



    public LodgingBuilding getPropertyOwner() {
        return lodgingBuilding;
    }

    public void setPropertyOwner(LodgingBuilding propertyOwner) {
        this.lodgingBuilding = propertyOwner;
    }


}
