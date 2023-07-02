package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;

@Entity
public class CompanyBankAccount extends BankAccount{

   @ManyToOne
   @JoinColumn(name = "CompanyID")
   private Company company;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
