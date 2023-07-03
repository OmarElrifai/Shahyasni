package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class BankAccount implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "AccountNo")
    private String accountNo;

    public Integer getId() { return id; }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }
}
