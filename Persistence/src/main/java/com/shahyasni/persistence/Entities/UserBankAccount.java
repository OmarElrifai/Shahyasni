package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class UserBankAccount extends BankAccount {

    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    public UserBankAccount(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
