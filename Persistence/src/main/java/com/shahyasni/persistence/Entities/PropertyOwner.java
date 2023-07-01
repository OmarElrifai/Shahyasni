package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class PropertyOwner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "FirstName")
    private Integer firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName")
    private String lastName;

    @OneToMany(mappedBy = "propertyOwner")
    private List<SupportingDocs> supportingDocuments;


    @Embedded
    private Address address;




    public Integer getID() { return id; }



    public Integer getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }


    public void setID(Integer ID) {

        this.id = ID;
    }


    public void setFirstName(Integer firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}