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
    private String newPassword;

    private  String salt;

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

    @ConstructorProperties({"id","fname","mname","lname","username","age","address"})
    public UserDTO(Integer id, String fname, String mname, String lname, String username, Integer age, String address){
        this.id = id;
        this.fname = fname;
        this.mname = mname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.age = age;
        this.address = address;
        this.salt = salt;
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



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public static UserDTO toUserModel(User user){
        return new UserDTO(user.getId(),user.getfname(), user.getMname(), user.getlname(), user.getUsername(), user.getAge(),user.getAddress());
    }



    public User setUserEntity(User user){
        User userEntity = new User();
        user.setfname(this.fname);
        user.setMname(this.mname);
        user.setlname(this.lname);
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setSalt(this.salt);
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


    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }
}
