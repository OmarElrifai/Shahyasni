package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Owner implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "MiddleName")
    private String middleName;

    @Column(name = "LastName")
    private String lastName;

    @OneToMany(mappedBy = "propertyOwner")
    @JsonbTransient
    private List<PrivateProperty> privateProperties;


    @Embedded
    private Address address;




    public Integer getId() { return id; }



    public String getFirstName() { return firstName; }
    public String getMiddleName() { return middleName; }
    public String getLastName() { return lastName; }


    public void setId(Integer ID) {

        this.id = ID;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    public List<PrivateProperty> getPrivateProperties() {
        return privateProperties;
    }

    public void setPrivateProperties(List<PrivateProperty> privateProperties) {
        this.privateProperties = privateProperties;
    }
}
