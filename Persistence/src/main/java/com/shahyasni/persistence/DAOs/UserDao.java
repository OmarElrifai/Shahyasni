package com.shahyasni.persistence.DAOs;

import com.shahyasni.persistence.DTOs.*;
import com.shahyasni.persistence.DTOs.ReservationDTOs.ReservationDTO;
import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.ReservationType.LodgingBuildingReservation;
import com.shahyasni.persistence.Entities.ReservationType.PrivatePropertyReservation;
import com.shahyasni.services.SecurityUtility;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Stateless
public class UserDao implements Serializable{

    @PersistenceContext
    private EntityManager em;

    @Inject
    private SecurityUtility util;

    public void insertUser(UserDTO user){

        Map<String, String> hashPassword = util.hashPassword(user.getPassword());
        user.setPassword(hashPassword.get("password"));
        user.setSalt(hashPassword.get("salt"));
        User userEntity = new User();
        em.persist(user.setUserEntity(userEntity));
    }



    public UserDTO findUserById(Integer  ID){

        return UserDTO.toUserModel(em.find(User.class, ID));
//        return em.find(User.class, ID);
    }


    public UserDTO findUserByUsername(String username){
        return UserDTO.toUserModel(em.createQuery("select u from User u where u.username = :username",User.class).setParameter("username",username).getSingleResult());
    }
    public String updatePassword(String username,String password,String newPassword){
        if(this.login(username,password)){
            User user = this.findUserEntityByUsername(username);
            Map<String,String> hashPassword = this.util.hashPassword(newPassword);
            user.setPassword(hashPassword.get("password"));
            user.setSalt(hashPassword.get("salt"));
            em.merge(user);
            return "Updated";
        }else {
            return "Invalid Password";
        }
    }



    public Boolean login(String username,String password){
        User user = this.findUserEntityByUsername(username);
        return this.util.validatePassword(password,user.getSalt(),user.getPassword());
    }


    public User findUserEntityByUsername(String username){
        return em.createQuery("select u from User u where u.username = :username",User.class).setParameter("username",username).getSingleResult();
    }

    public List<UserDTO> findAllUsers(){

        List<UserDTO> users = new ArrayList<>();
        em.createQuery("select u from User u", User.class).getResultList().forEach(user -> {
             UserDTO userDTO = UserDTO.toUserModel(user);
             users.add(userDTO);
        });
        return users;
    }

    public User updateUser(UserDTO userDTO){
        User user = em.find(User.class,userDTO.getId());
        return em.merge(userDTO.setUserEntity(user));
    }

    public void deleteUser(Integer id){
        User User = em.find(User.class, id);
        em.remove(User);
    }


    public void addBankAccount(UserBankAccountDTO userBankAccountDTO){
        UserBankAccount userBankAccount = new UserBankAccount();
        User user = em.find(User.class,userBankAccountDTO.getUserId());
        em.persist(userBankAccountDTO.setUserBankAccountEntity(userBankAccount,user));

    }

    public List<UserBankAccount> getBankAccountsForUser(Integer userId){
        return em.createQuery("select b from UserBankAccount b join b.user u where u.id = :userId",UserBankAccount.class).setParameter("userId",userId).getResultList();
    }

    public UserBankAccount updateBankAccount(UserBankAccountDTO userBankAccountDTO){

        UserBankAccount userBankAccount = em.find(UserBankAccount.class,userBankAccountDTO.getBankAccountId());
        User user= em.find(User.class,userBankAccountDTO.getUserId());
        return em.merge(userBankAccountDTO.setUserBankAccountEntity(userBankAccount,user));
    }

    public void removeBankAccount(Integer bankAccountId){
       UserBankAccount bankAccount = em.find(UserBankAccount.class, bankAccountId);
       em.remove(bankAccount);
    }


    public void createTripOrder(TripOrderDTO tripOrderDTO){
            TripOrder tripOrder = new TripOrder();
            User user = em.find(User.class,tripOrderDTO.getUserId());
            Trip trip = em.find(Trip.class,tripOrderDTO.getTripId());
            Transportation transportation = em.find(Transportation.class,tripOrderDTO.getTransportationId());
            if(tripOrderDTO.isLodgingBuildingReservation){
                LodgingBuildingReservation lodgingBuildingReservation = em.find(LodgingBuildingReservation.class,tripOrderDTO.getAccomodationReservationId());
                em.persist(tripOrderDTO.setTripOrderEntity(tripOrder,user,transportation,trip,lodgingBuildingReservation));
            }else{
                PrivatePropertyReservation privatePropertyReservation = em.find(PrivatePropertyReservation.class,tripOrderDTO.getAccomodationReservationId());
                em.persist(tripOrderDTO.setTripOrderEntity(tripOrder,user,transportation,trip,privatePropertyReservation));
            }


    }

    public List<Object[]> getTripOrdersForUser(Integer userId){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.UserTrips(o.id,location , seats , o.totalDueAmount, trans.departureDate, u.fname, u.lname, u.username) from TripOrder o join o.trip t join o.transportation trans join o.user u  join o.seats seats join t.locations location where u.id = :userId", Object[].class).setParameter("userId",userId).getResultList();
    }






    public List<Object[]> getTripOrderForLodgingBuilding(Integer orderId){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.TripOrderDetails(o.id, u.username, t.tripDetails,location, seats, trans.companyName,t.pickUpLocation,trans.departureDate,trans.departureTime,trans.arrivalDate,trans.arrivalTime,o.totalDueAmount,l.name) from TripOrder o join o.user u join o.trip t join t.locations location join o.seats seats join o.transportation trans  join o.lodgingBuildingReservation.lodgingBuilding l where o.id = :orderId", Object[].class).setParameter("orderId",orderId).getResultList();
    }

    public List<Object[]> getTripOrderForPrivateProperty(Integer orderId){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.TripOrderDetails(o.id, u.username, t.tripDetails, location, seats, trans.companyName,t.pickUpLocation,trans.departureDate,trans.departureTime,trans.arrivalDate,trans.arrivalTime,o.totalDueAmount,p.name) from TripOrder o join o.user u join o.trip t  join t.locations location join o.seats seats join o.transportation trans join o.privatePropertyReservation.privateProperty p where o.id = :orderId", Object[].class).setParameter("orderId",orderId).getResultList();
    }

    public List<Object[]> getTripOrdersInTimeWindow(LocalDate from, LocalDate to){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.UserTrips(o.id,location ,seats, o.totalDueAmount, trans.departureDate, u.fname, u.lname, u.username) from TripOrder o join o.trip t join o.transportation trans join o.user u join o.seats seats join t.locations location where trans.departureDate between   :from and :to", Object[].class).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public List<Object[]> getTripOrdersForUserInTimeWindow(Integer userId, LocalDate from, LocalDate to){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.UserTrips(o.id,location ,seats, o.totalDueAmount, trans.departureDate, u.fname, u.lname, u.username) from TripOrder o join o.trip t join o.transportation trans join o.user u join o.seats seats join t.locations location  where u.id = :userId and trans.departureDate between   :from and :to", Object[].class).setParameter("userId", userId).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public void updateTripOrder(TripOrderDTO tripOrderDTO){
            TripOrder tripOrder = em.find(TripOrder.class,tripOrderDTO.getTripOrderId());
            User user = em.find(User.class,tripOrderDTO.getUserId());
            Trip trip = em.find(Trip.class,tripOrderDTO.getTripId());
            Transportation transportation = em.find(Transportation.class,tripOrderDTO.getTransportationId());
            if(tripOrderDTO.isLodgingBuildingReservation){
                LodgingBuildingReservation lodgingBuildingReservation = em.find(LodgingBuildingReservation.class,tripOrderDTO.getAccomodationReservationId());
                em.merge(tripOrderDTO.setTripOrderEntity(tripOrder,user,transportation,trip,lodgingBuildingReservation));
            }else{
                PrivatePropertyReservation privatePropertyReservation = em.find(PrivatePropertyReservation.class,tripOrderDTO.getAccomodationReservationId());
                em.merge(tripOrderDTO.setTripOrderEntity(tripOrder,user,transportation,trip,privatePropertyReservation));
            }

    }

    public void deleteTripOrder(Integer tripOrderId){
        TripOrder tripOrder = em.find(TripOrder.class, tripOrderId);
        em.remove(tripOrder);
    }

    public void reserveLodgingAccomodation(ReservationDTO reservationDTO){
            LodgingBuilding lodgingBuilding = em.find(LodgingBuilding.class,reservationDTO.getAccomodationId());
            User user = em.find(User.class,reservationDTO.getUserId());
            LodgingBuildingReservation lodgingBuildingReservation = new LodgingBuildingReservation();
            em.persist(reservationDTO.setLodgingBuildingReservationEntity(lodgingBuildingReservation,lodgingBuilding,user));

    }

    public List<ReservationDTO> getLodgingReservationForUser(Integer userId){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.ReservationDTOs.ReservationDTO(r.id, r.noOfSingleRooms, r.noOfDoubleRooms, r.noOfTripleRooms, r.fromDate, r.toDate, u.id, l.id,l.name) from LodgingBuildingReservation r join r.lodgingBuilding l join r.user u where u.id= :userId",ReservationDTO.class).setParameter("userId", userId).getResultList();
    }

    public List<ReservationDTO> getLodgingReservationInTimeWindow(LocalDate from, LocalDate to){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.ReservationDTOs.ReservationDTO(r.id, r.noOfSingleRooms, r.noOfDoubleRooms, r.noOfTripleRooms, r.fromDate, r.toDate, u.id, l.id,l.name) from LodgingBuildingReservation r join r.lodgingBuilding l join r.user u where r.fromDate = :from and r.toDate = :to",ReservationDTO.class).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public List<ReservationDTO> getUserLodgingReservationInTimeWindow(Integer userId , LocalDate from, LocalDate to){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.ReservationDTOs.ReservationDTO(r.id, r.noOfSingleRooms, r.noOfDoubleRooms, r.noOfTripleRooms, r.fromDate, r.toDate, u.id, l.id,l.name) from LodgingBuildingReservation r join r.lodgingBuilding l join r.user u where u.id= :userId and r.fromDate = :from and r.toDate = :to",ReservationDTO.class).setParameter("userId", userId).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public LodgingBuildingReservation updateLodgingReservation(ReservationDTO reservationDTO){
        LodgingBuildingReservation lodgingBuildingReservation = em.find(LodgingBuildingReservation.class,reservationDTO.getReservationId());
        LodgingBuilding lodgingBuilding = em.find(LodgingBuilding.class,reservationDTO.getAccomodationId());
        User user = em.find(User.class,reservationDTO.getUserId());
        return em.merge(reservationDTO.setLodgingBuildingReservationEntity(lodgingBuildingReservation,lodgingBuilding,user));
    }
    public void removeLodgingAccomodationReservation(Integer reservationId){
        LodgingBuildingReservation reservation = em.find(LodgingBuildingReservation.class, reservationId);
        em.remove(reservation);
    }

    public void reservePrivateProperty(ReservationDTO reservationDTO){
        try {
            PrivateProperty privateProperty = em.find(PrivateProperty.class,reservationDTO.getAccomodationId());
            User user = em.find(User.class,reservationDTO.getUserId());
            PrivatePropertyReservation privatePropertyReservation = new PrivatePropertyReservation();
            em.persist(reservationDTO.setPrivatePropertyReservationEntity(privatePropertyReservation,privateProperty,user));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public List<ReservationDTO> getPrivatePropertyReservationsForUser(Integer userId){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.ReservationDTOs.ReservationDTO(r.id, r.noOfSingleRooms, r.noOfDoubleRooms, r.noOfTripleRooms, r.fromDate, r.toDate, u.id, p.id,p.name) from PrivatePropertyReservation r join r.privateProperty p join r.user u where u.id= :userId",ReservationDTO.class).setParameter("userId", userId).getResultList();
    }

    public List<ReservationDTO> getPrivatePropertyInTimeWindow(LocalDate from, LocalDate to){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.ReservationDTOs.ReservationDTO(r.id, r.noOfSingleRooms, r.noOfDoubleRooms, r.noOfTripleRooms, r.fromDate, r.toDate, u.id, p.id,p.name) from PrivatePropertyReservation r join r.privateProperty p join r.user u where r.fromDate = :from and r.toDate = :to",ReservationDTO.class).setParameter("from",from).setParameter("to",to).getResultList();
    }

    public List<ReservationDTO> getUserPrivatePropertyInTimeWindow(Integer userId , LocalDate from, LocalDate to){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.ReservationDTOs.ReservationDTO(r.id, r.noOfSingleRooms, r.noOfDoubleRooms, r.noOfTripleRooms, r.fromDate, r.toDate, u.id, p.id,p.name) from PrivatePropertyReservation r join r.privateProperty p join r.user u where u.id= :userId and r.fromDate = :from and r.toDate = :to",ReservationDTO.class).setParameter("userId", userId).setParameter("from",from).setParameter("to",to).getResultList();
    }


    public PrivatePropertyReservation updatePrivatePropertyReservation(ReservationDTO reservationDTO){

        PrivatePropertyReservation privatePropertyReservation = em.find(PrivatePropertyReservation.class,reservationDTO.getReservationId());
        PrivateProperty privateProperty = em.find(PrivateProperty.class,reservationDTO.getAccomodationId());
        User user = em.find(User.class,reservationDTO.getUserId());
        return em.merge(reservationDTO.setPrivatePropertyReservationEntity(privatePropertyReservation,privateProperty,user));
    }
    public void removePrivatePropertyReservation(Integer reservationId){
        PrivatePropertyReservation reservation = em.find(PrivatePropertyReservation.class, reservationId);
        em.remove(reservation);
    }



}
