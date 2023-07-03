package com.shahyasni.persistence.DAOs;

import com.shahyasni.persistence.DTOs.LodgingBuildingOrderDetails;
import com.shahyasni.persistence.DTOs.OrdersSummary;
import com.shahyasni.persistence.DTOs.PrivatePropertyOrderDetails;
import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.PropertyTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.PropertyTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.ReservationType.LodgingBuildingReservation;
import com.shahyasni.persistence.Entities.ReservationType.PrivatePropertyReservation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;



@Stateless
public class UserModel implements Serializable{

    @PersistenceContext
    private EntityManager em;

    public void insert(User User){
        try {
            em.persist(User);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public List<User> findAll(){
        return em.createQuery("select u from User u", User.class).getResultList() ;
    }

    public User findUserByID(Integer  ID){
        return em.find(User.class, ID);
    }

    public User findUserByUsername(String username){
        return em.createQuery("select u from User u where u.username = :username",User.class).setParameter("username",username).getSingleResult();
    }

    public User Update(User User){
        return em.merge(User);
    }

    public void Delete(Integer id){
        User User = em.find(User.class, id);
        em.remove(User);
    }

    public void addBankAccount(UserBankAccount bankAccount){
        try {
            em.persist(bankAccount);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void removeBankAccount(Integer bankAccountId){
       UserBankAccount bankAccount = em.find(UserBankAccount.class, bankAccountId);
       try {
           em.remove(bankAccount);
       }catch (Exception e){
            System.out.println(e);
        }

    }

    public List<UserBankAccount> getBankAccounts(Integer userId){
        return em.createQuery("select b.accountNo from User u join u.userBankAccounts b",UserBankAccount.class).getResultList();
    }

    public void createTripOrder(TripOrder tripOrder){
        try {
            em.persist(tripOrder);
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public List<OrdersSummary> getTripOrdersForUser(Integer userId){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.OrdersSummary(t.location, o.totalDueAmount, trans.departureDate, u.fname, u.lname, u.username) from TripOrder o join o.trip t join o.transportation trans join o.user u where u.id = :userId", OrdersSummary.class).setParameter("userId",userId).getResultList();
    }



    public LodgingBuildingOrderDetails getTripOrderForLodgingBuilding(Integer orderId){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.LodgingBuildingOrderDetails(o.id, t.tripDetails,location.city,trans.companyName,trans.departureDate,trans.departureTime,trans.arrivalDate,trans.arrivalTime,o.totalDueAmount,o.lodgingBuilding.name) from TripOrder o join o.user u join o.trip t join o.lodgingBuilding l  join o.transportation trans  join o.lodgingBuilding.location location  where o.id = :orderId", LodgingBuildingOrderDetails.class).setParameter("orderId",orderId).getSingleResult();
    }

    public PrivatePropertyOrderDetails getTripOrderForPrivateProperty(Integer orderId){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.PrivatePropertyOrderDetails(o.id,t.tripDetails,location.city,trans.companyName,trans.departureDate,trans.departureTime,trans.arrivalDate,trans.arrivalTime,o.totalDueAmount) from TripOrder o join o.user u join o.trip t join o.privateProperty p join o.transportation trans join o.lodgingBuilding.location location  where o.id = :orderId", PrivatePropertyOrderDetails.class).setParameter("orderId",orderId).getSingleResult();
    }

    public List<OrdersSummary> getTripOrdersInTimeWindow(LocalDate from, LocalDate to){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.OrdersSummary(t.location, o.totalDueAmount, trans.departureDate, u.fname, u.lname, u.username) from TripOrder o join o.trip t join o.transportation trans join o.user u where trans.departureDate between   :from and :to", OrdersSummary.class).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public List<OrdersSummary> getTripOrdersForUserInTimeWindow(Integer userId,LocalDate from, LocalDate to){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.OrdersSummary(t.location, o.totalDueAmount, trans.departureDate, u.fname, u.lname, u.username) from TripOrder o join o.trip t join o.transportation trans join o.user u where u.id = :userId and trans.departureDate between   :from and :to", OrdersSummary.class).setParameter("userId", userId).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public void deleteTripOrder(Integer tripOrderId){
        TripOrder tripOrder = em.find(TripOrder.class, tripOrderId);
        try {
            em.remove(tripOrder);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void reserveLodgingAccomodation(LodgingBuildingReservation reservation){
        try {
            em.persist(reservation);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<LodgingBuilding> getLodgingAccomodationReservation(Integer userId){
        return em.createQuery("select r from LodgingBuildingReservation r join r.lodgingBuilding l join r.user u where u.id= :userId",LodgingBuilding.class).setParameter("userId", userId).getResultList();
    }

    public List<LodgingBuilding> getLodgingReservationInTimeWindow(LocalDate from, LocalDate to){
        return em.createQuery("select r from LodgingBuildingReservation r join r.lodgingBuilding l join r.user u where r.fromDate = :from and r.toDate = :to",LodgingBuilding.class).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public List<LodgingBuilding> getUserLodgingReservationInTimeWindow(Integer userId , LocalDate from, LocalDate to){
        return em.createQuery("select r from LodgingBuildingReservation r join r.lodgingBuilding l join r.user u where u.id= :userId and r.fromDate = :from and r.toDate = :to",LodgingBuilding.class).setParameter("userId", userId).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public void removeLodgingAccomodationReservation(Integer reservationId){
        LodgingBuildingReservation reservation = em.find(LodgingBuildingReservation.class, reservationId);
        em.remove(reservation);
    }

    public void reservePrivateProperty(PrivatePropertyReservation reservation){
        try {
            em.persist(reservation);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<PrivateProperty> getPrivatePropertyReservation(Integer userId){
        return em.createQuery("select r from PrivatePropertyReservation r join r.privateProperty l join r.user u where u.id= :userId",PrivateProperty.class).setParameter("userId", userId).getResultList();
    }

    public List<PrivateProperty> getPrivatePropertyInTimeWindow(LocalDate from, LocalDate to){
        return em.createQuery("select r from PrivatePropertyReservation r join r.privateProperty l join r.user u where r.fromDate = :from and r.toDate = :to",PrivateProperty.class).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public List<PrivateProperty> getUserPrivatePropertyInTimeWindow(Integer userId , LocalDate from, LocalDate to){
        return em.createQuery("select r from PrivatePropertyReservation r join r.privateProperty l join r.user u where u.id= :userId and r.fromDate = :from and r.toDate = :to",PrivateProperty.class).setParameter("userId", userId).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public void removePrivatePropertyReservation(Integer reservationId){
        PrivatePropertyReservation reservation = em.find(PrivatePropertyReservation.class, reservationId);
        em.remove(reservation);
    }



}
