package com.shahyasni.persistence.Entities.SupportingDocsEntities;


import com.shahyasni.persistence.Entities.Company;
import com.shahyasni.persistence.Entities.SupportingDocs;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompanySupportingDocs extends SupportingDocs {
    @ManyToOne
    @JoinColumn(name = "CompanyResources")
    private Company company;


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
