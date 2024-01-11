package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.CommentsEntities.CompanyComments;
import com.shahyasni.persistence.Entities.CommentsEntities.LodgingBuildingComments;
import com.shahyasni.persistence.Entities.CommentsEntities.PrivatePropertyComments;
import com.shahyasni.persistence.Entities.ReservationType.LodgingBuildingReservation;
import com.shahyasni.persistence.Entities.ReservationType.PrivatePropertyReservation;

import java.beans.ConstructorProperties;
import java.util.List;

public class UserDTO {

    private Integer id;

    private String fname;

    private String mname;

    private String lname;

    private String username;

    private String password;

    private Integer age;

    private String address;
//
//
//    private List<LodgingBuildingReservation> lodgingBuildingReservations ;
//
//    private List<PrivatePropertyReservation> privatePropertyReservations ;

//    private List<TripOrder> tripsOrders;
//
//
//    private List<UserBankAccount> userBankAccounts ;
//
//    private List<Transportation> transportation ;
//
//    private List<LodgingBuildingComments> lodgingBuildingcomments ;
//
//    private List<PrivatePropertyComments> privatePropertyComments ;
//
//    private List<CompanyComments> companyComments ;

    @ConstructorProperties({"id","fname","mname","lname","username","password","age","address"})
    public UserDTO(Integer id, String fname, String mname, String lname, String username, String password, Integer age, String address){
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
//        this.lodgingBuildingReservations = lodgingBuildingReservations;
//        this.privatePropertyReservations = privatePropertyReservations;

    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }





//    public List<LodgingBuildingReservation> getLodgingBuildingReservations() {
//        return lodgingBuildingReservations;
//    }
//
//    public void setLodgingBuildingReservations(List<LodgingBuildingReservation> lodgingBuildingReservations) {
//        this.lodgingBuildingReservations = lodgingBuildingReservations;
//    }
//
//    public List<PrivatePropertyReservation> getPrivatePropertyReservations() {
//        return privatePropertyReservations;
//    }
//
//    public void setPrivatePropertyReservations(List<PrivatePropertyReservation> privatePropertyReservations) {
//        this.privatePropertyReservations = privatePropertyReservations;
//    }


//    public List<TripOrder> getTripsOrders() {
//        return tripsOrders;
//    }
//
//     public void setTripsOrders(List<TripOrder> tripsOrders) {
//        this.tripsOrders = tripsOrders;
//    }
//
//    public List<UserBankAccount> getUserBankAccounts() {
//        return userBankAccounts;
//    }
//
//    public void setUserBankAccounts(List<UserBankAccount> userBankAccounts) {
//        this.userBankAccounts = userBankAccounts;
//    }
//
//    public List<Transportation> getTransportation() {
//        return transportation;
//    }
//
//    public void setTransportation(List<Transportation> transportation) {
//        this.transportation = transportation;
//    }
//
//    public List<LodgingBuildingComments> getLodgingBuildingcomments() {
//        return lodgingBuildingcomments;
//    }
//
//    public void setLodgingBuildingcomments(List<LodgingBuildingComments> lodgingBuildingcomments) {
//        this.lodgingBuildingcomments = lodgingBuildingcomments;
//    }
//
//    public List<PrivatePropertyComments> getPrivatePropertyComments() {
//        return privatePropertyComments;
//    }
//
//    public void setPrivatePropertyComments(List<PrivatePropertyComments> privatePropertyComments) {
//        this.privatePropertyComments = privatePropertyComments;
//    }
//
//    public List<CompanyComments> getCompanyComments() {
//        return companyComments;
//    }
//
//    public void setCompanyComments(List<CompanyComments> companyComments) {
//        this.companyComments = companyComments;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static UserDTO toUserModel(User user){
        return new UserDTO(user.getId(),user.getfname(), user.getMname(), user.getlname(), user.getUsername(), user.getPassword(), user.getAge(),user.getAddress());
    }



    public User setUserEntity(User user){
        user.setfname(this.fname);
        user.setMname(this.mname);
        user.setlname(this.lname);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setAddress(this.address);
        user.setAge(this.age);
//        user.setLodgingBuildingReservations(this.lodgingBuildingReservations);
//        user.setLodgingBuildingComments(this.lodgingBuildingcomments);
//        user.setPrivatePropertyReservations(this.privatePropertyReservations);
//        user.setPrivatePropertyComments(this.privatePropertyComments);
//        user.setUserBankAccounts(this.userBankAccounts);
//        user.setTripsOrders(this.tripsOrders);
        return user;
    }


}
