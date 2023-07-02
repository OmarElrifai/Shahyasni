package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;

    @Column(name = "AccountNo")
    private String accountNo;

    public Integer getID() { return ID; }


    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
