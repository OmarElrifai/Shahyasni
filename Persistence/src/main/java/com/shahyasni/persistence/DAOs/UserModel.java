package com.shahyasni.persistence.DAOs;

import com.shahyasni.persistence.DTOs.LodgingBuildingOrderDetails;
import com.shahyasni.persistence.Entities.*;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
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
       em.remove(bankAccount);
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

    public LodgingBuildingOrderDetails getTripOrderForLodgingBuilding(Integer userId){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.LodgingBuildingOrderDetails(o.id, u.username,t.tripDetails,trans.location.city,trans.companyName,trans.departureDate,trans.departureTime,trans.arrivalDate,trans.arrivalTime,o.totalDueAmount,o.lodgingBuilding.name) from TripOrder o join o.user u join o.trip t join o.lodgingBuilding l join o.privateProperty p join o.transportation trans where u.id = :id", LodgingBuildingOrderDetails.class).setParameter("id",userId).getSingleResult();
    }

    public LodgingBuildingOrderDetails getTripOrderForPrivateProperty(Integer userId){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.PrivatePropertyOrderDetails(o.id, u.username,t.tripDetails,trans.location.city,trans.companyName,trans.departureDate,trans.departureTime,trans.arrivalDate,trans.arrivalTime,o.totalDueAmount) from TripOrder o join o.user u join o.trip t join o.lodgingBuilding l join o.privateProperty p join o.transportation trans where u.id = :id", LodgingBuildingOrderDetails.class).setParameter("id",userId).getSingleResult();
    }

    public void deleteTripOrder(Integer tripOrderId){
        TripOrder tripOrder = em.find(TripOrder.class, tripOrderId);
        em.remove(tripOrder);
    }
}
