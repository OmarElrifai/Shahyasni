package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.CommentsEntities.CompanyComments;
import com.shahyasni.persistence.Entities.SupportingDocsEntities.CompanySupportingDocs;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Company  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @OneToMany(mappedBy = "company")
    @JsonbTransient
    private List<CompanyBankAccount> companyBankAccounts = new ArrayList<>();;

    @OneToMany(mappedBy = "company")
    @JsonbTransient
    private List<CompanySupportingDocs> supportingDocs = new ArrayList<>();;

    @OneToMany(mappedBy = "company")
    @JsonbTransient
    private List<Trip> trips = new ArrayList<>();;

    @Column(name = "StaffEvaluation")
    private double staffEvaluation;

    @Column(name = "TripsRating")
    private double tripRating;


    @OneToMany(mappedBy = "company")
    @JsonbTransient
    private List<CompanyComments> comments = new ArrayList<>();;



    @Embedded
    private Address address;

    public Integer getId() { return id; }
    public String getName() { return name; }


    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Company(){

    }

    public List<CompanyBankAccount> getCompanyBankAccounts() {
        return companyBankAccounts;
    }

    public void setCompanyBankAccounts(List<CompanyBankAccount> companyBankAccounts) {
        this.companyBankAccounts = companyBankAccounts;
    }

    public List<CompanySupportingDocs> getSupportingDocs() {
        return supportingDocs;
    }

    public void setSupportingDocs(List<CompanySupportingDocs> supportingDocs) {
        this.supportingDocs = supportingDocs;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }


    public double getTripRating() {
        return tripRating;
    }

    public void setTripRating(double tripRating) {
        this.tripRating = tripRating;
    }

    public double getStaffEvaluation() {
        return staffEvaluation;
    }

    public void setStaffEvaluation(double staffEvaluation) {
        this.staffEvaluation = staffEvaluation;
    }

    public List<CompanyComments> getComments() {
        return comments;
    }

    public void setComments(List<CompanyComments> comments) {
        this.comments = comments;
    }



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
