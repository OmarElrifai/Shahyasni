package com.shahyasni.persistence.Entities.SupportingDocsEntities;

import com.shahyasni.persistence.Entities.PropertyOwnerEntities.PrivateProperty;
import com.shahyasni.persistence.Entities.SupportingDocs;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PrivatePropertySupportingDocs extends SupportingDocs {
    @ManyToOne
    @JoinColumn(name = "PrivatePropertyID")
    private PrivateProperty privateProperty;


    public PrivateProperty getPrivateProperty() {
        return privateProperty;
    }

    public void setPrivateProperty(PrivateProperty privateProperty) {
        this.privateProperty = privateProperty;
    }
}
