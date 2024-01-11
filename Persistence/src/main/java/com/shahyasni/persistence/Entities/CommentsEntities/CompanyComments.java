package com.shahyasni.persistence.Entities.CommentsEntities;


import com.shahyasni.persistence.Entities.Comments;
import com.shahyasni.persistence.Entities.Company;
import com.shahyasni.persistence.Entities.User;

import javax.persistence.*;

@Entity
public class CompanyComments extends Comments {

    @ManyToOne
    @Basic(fetch = FetchType.LAZY)
    @JoinColumn(name = "User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "CompanyResources")
    private Company company;
//
     public User getUser() {
        return user;
    }

    public void setUser(User userID) {
        this.user = userID;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
