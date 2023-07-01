package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import javax.xml.stream.events.Comment;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer ID;

    @Column(name = "FirstName")
    private String fname;

    @Column(name = "MiddleName")
    private String mname;

    @Column(name = "LastName")
    private String lname;

    @Column(name = "Username",unique = true)
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "Age")
    private Integer age;

    @Column(name = "Address")
    private String address;

    @Column(name = "DateOfAccountCreation")
    private LocalDate createdDate;

    @OneToMany(mappedBy = "user")
    private List<Reservations> reservations = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "Trips", joinColumns = @JoinColumn(name = "TripID"), inverseJoinColumns = @JoinColumn(name = "UserID"))
    private List<Trip> trips = new ArrayList<>() ;

    @OneToMany(mappedBy = "user")
    private List<BankAccount> bankAccounts = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "Transportation")
    private Transportation transportation ;

    @OneToMany(mappedBy = "userID")
    private List<CampComments> comment;

    public User(){

    }

    @PrePersist
    public void recordCreation(){
        setCreatedDate(LocalDate.now());
    }

    public Integer getID() { return this.ID; }
    public String getfname(){ return this.fname; }
    public String getMname() { return this.mname; }
    public String getlname(){ return this.lname; }
    public String getUsername() { return this.username; }
    public String getPassword(){ return this.password; }
    public Integer getAge(){ return this.age; }
    public String getAddress(){ return this.address; }
    public LocalDate getCreatedDate() { return this.createdDate; }
    public List<Trip> getTrips() { return trips; }



    public void setID(Integer ID) {

        this.ID = ID;
    }

    public void setfname(String fname) {

        this.fname = fname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public void setlname(String lname) {

        this.lname = lname;
    }

    public void setUsername(String username) {

        this.username = username;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setAge(Integer age) {

        this.age = age;
    }

    public void setAddress(String address) {

        this.address = address;
    }




    private void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }






//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        User user = (User) o;
//        return Objects.equals(username, user.username);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(username);
//    }


}

