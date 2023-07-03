package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Property implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Embedded
    private Address address;


    public Integer getId() { return id; }
    public Address getAddress() { return address; }


    public void setId(Integer ID) {
        this.id = ID;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
