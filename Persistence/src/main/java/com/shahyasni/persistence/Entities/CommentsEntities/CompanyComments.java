package com.shahyasni.persistence.Entities.CommentsEntities;


import com.shahyasni.persistence.Entities.Comments;
import com.shahyasni.persistence.Entities.Company;
import com.shahyasni.persistence.Entities.User;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class CompanyComments extends Comments {

    @ManyToOne
    @JoinColumn(name = "User")
    private User userID;

    @ManyToOne
    @JoinColumn(name = "Company")
    private Company company;

     public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
