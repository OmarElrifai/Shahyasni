package com.shahyasni.persistence.Entities.SupportingDocsEntities;

import com.shahyasni.persistence.Entities.PropertyOwnerEntities.Camp;
import com.shahyasni.persistence.Entities.SupportingDocs;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CampSupportingDocs extends SupportingDocs {
    @ManyToOne
    @JoinColumn(name = "CampID")
    private Camp camp;

    public Camp getPropertyOwner() {
        return camp;
    }

    public void setPropertyOwner(Camp propertyOwner) {
        this.camp = propertyOwner;
    }
}
