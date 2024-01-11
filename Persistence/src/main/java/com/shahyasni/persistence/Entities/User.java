package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.CommentsEntities.CompanyComments;
import com.shahyasni.persistence.Entities.CommentsEntities.LodgingBuildingComments;
import com.shahyasni.persistence.Entities.CommentsEntities.PrivatePropertyComments;
import com.shahyasni.persistence.Entities.ReservationType.LodgingBuildingReservation;
import com.shahyasni.persistence.Entities.ReservationType.PrivatePropertyReservation;
//import javax.json.bind.annotation.JsonbTransient;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;




@Entity
//@NamedQuery(name = User.getUserByUserName,)
public class User implements Serializable {

    private static final String getUserByUserName = "User.username";


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

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
    @JsonbTransient
    private List<LodgingBuildingReservation> lodgingBuildingReservations = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonbTransient
    private List<PrivatePropertyReservation> privatePropertyReservations = new ArrayList<>();
//
    @OneToMany(mappedBy = "user")
    @JsonbTransient
    private List<TripOrder> tripsOrders = new ArrayList<>();

    @OneToMany(mappedBy = "user")
    @JsonbTransient
    private List<UserBankAccount> userBankAccounts  = new ArrayList<>();

    @ManyToMany
    @JsonbTransient
    @JoinTable(name = "UserTransportations",joinColumns = @JoinColumn(name = "User"),inverseJoinColumns = @JoinColumn(name = "Transportation"))
    private List<Transportation> transportation ;

    @OneToMany(mappedBy = "user")
    @JsonbTransient
    private List<LodgingBuildingComments> lodgingBuildingComments = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    @JsonbTransient
    private List<PrivatePropertyComments> privatePropertyComments = new ArrayList<>();


    @OneToMany(mappedBy = "user")
    @JsonbTransient
    private List<CompanyComments> companyComments = new ArrayList<>();

    public User(){

    }

    @PrePersist
    public void recordCreation(){
        setCreatedDate(LocalDate.now());
    }

    public Integer getId() { return this.id; }
    public String getfname(){ return this.fname; }
    public String getMname() { return this.mname; }
    public String getlname(){ return this.lname; }
    public String getUsername() { return this.username; }
    public String getPassword(){ return this.password; }
    public Integer getAge(){ return this.age; }
    public String getAddress(){ return this.address; }
    public LocalDate getCreatedDate() { return this.createdDate; }
//    public List<TripOrder> getTripsOrders() { return tripsOrders; }



    public void setId(Integer id) {

        this.id = id;
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




    public List<PrivatePropertyReservation> getPrivatePropertyReservations() {
        return privatePropertyReservations;
    }

    public void setPrivatePropertyReservations(List<PrivatePropertyReservation> privatePropertyReservations) {
        this.privatePropertyReservations = privatePropertyReservations;
    }

    public List<LodgingBuildingReservation> getLodgingBuildingReservations() {
        return lodgingBuildingReservations;
    }

    public void setLodgingBuildingReservations(List<LodgingBuildingReservation> lodgingBuildingReservations) {
        this.lodgingBuildingReservations = lodgingBuildingReservations;
    }

    public List<LodgingBuildingComments> getLodgingBuildingComments() {
        return lodgingBuildingComments;
    }

    public void setLodgingBuildingComments(List<LodgingBuildingComments> comments) {
        this.lodgingBuildingComments = comments;
    }

    public List<UserBankAccount> getUserBankAccounts() {
        return userBankAccounts;
    }

    public void setUserBankAccounts(List<UserBankAccount> userBankAccounts) {
        this.userBankAccounts = userBankAccounts;
    }

    public List<Transportation> getTransportation() {
        return transportation;
    }

    public void setTransportation(List<Transportation> transportation) {
        this.transportation = transportation;
    }

    public List<PrivatePropertyComments> getPrivatePropertyComments() {
        return privatePropertyComments;
    }

    public void setPrivatePropertyComments(List<PrivatePropertyComments> privatePropertyComments) {
        this.privatePropertyComments = privatePropertyComments;
    }

    public List<CompanyComments> getCompanyComments() {
        return companyComments;
    }

    public void setCompanyComments(List<CompanyComments> companyComments) {
        this.companyComments = companyComments;
    }

    public List<TripOrder> getTripsOrders() {
        return tripsOrders;
    }

    public void setTripsOrders(List<TripOrder> tripsOrders) {
        this.tripsOrders = tripsOrders;
    }

//    public void setTripsOrders(List<TripOrder> tripsOrders){
//        this.tripsOrders = tripsOrders;
//    }

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

