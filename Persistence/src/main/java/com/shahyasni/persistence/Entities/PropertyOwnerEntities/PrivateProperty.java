package com.shahyasni.persistence.Entities.PropertyOwnerEntities;

import com.shahyasni.persistence.Entities.Property;
import com.shahyasni.persistence.Entities.PropertyPhotosEntities.IndividualPhotos;
import com.shahyasni.persistence.Entities.SupportingDocsEntities.PrivatePropertySupportingDocs;

import javax.persistence.*;
import java.util.List;

@Entity
public class PrivateProperty extends Property{

    @OneToMany(mappedBy = "privateProperty")
    private List<PrivatePropertySupportingDocs> supportingDocuments;

    @OneToMany(mappedBy = "privateProperty")
    private List<IndividualPhotos> individualPhotos;

    public PrivateProperty(){

    }






    public List<IndividualPhotos> getIndividualPhotos() {
        return individualPhotos;
    }

    public void setIndividualPhotos(List<IndividualPhotos> individualPhotos) {
        this.individualPhotos = individualPhotos;
    }

    public List<PrivatePropertySupportingDocs> getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(List<PrivatePropertySupportingDocs> supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }
}
