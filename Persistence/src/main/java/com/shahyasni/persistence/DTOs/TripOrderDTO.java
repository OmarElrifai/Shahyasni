package com.shahyasni.persistence.DTOs;

import com.shahyasni.persistence.Entities.ReservationType.LodgingBuildingReservation;
import com.shahyasni.persistence.Entities.ReservationType.PrivatePropertyReservation;
import com.shahyasni.persistence.Entities.Transportation;
import com.shahyasni.persistence.Entities.Trip;
import com.shahyasni.persistence.Entities.TripOrder;
import com.shahyasni.persistence.Entities.User;
import java.util.List;
import javax.persistence.Column;
import java.time.LocalDate;

public class TripOrderDTO {
    private Integer tripOrderId;
    private Integer userId;
    private Integer tripId;
    private Integer transportationId;
    private List<Integer> seats;
    private LocalDate orderCreationDate;
    private double totalDueAmount;
    public Boolean isLodgingBuildingReservation;
    private Integer accomodationReservationId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getTripId() {
        return tripId;
    }

    public void setTripId(Integer tripId) {
        this.tripId = tripId;
    }

    public Integer getTransportationId() {
        return transportationId;
    }

    public void setTransportationId(Integer transportationId) {
        this.transportationId = transportationId;
    }

    public LocalDate getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(LocalDate orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public double getTotalDueAmount() {
        return totalDueAmount;
    }

    public void setTotalDueAmount(double totalDueAmount) {
        this.totalDueAmount = totalDueAmount;
    }


    public List<Integer> getSeats() {
        return seats;
    }

    public void setSeats(List<Integer> seats) {
        this.seats = seats;
    }
    public Integer getTripOrderId() {
        return tripOrderId;
    }

    public void setTripOrderId(Integer tripOrderId) {
        this.tripOrderId = tripOrderId;
    }



    public Integer getAccomodationReservationId() {
        return accomodationReservationId;
    }

    public void setAccomodationReservationId(Integer accomodationReservationId) {
        this.accomodationReservationId = accomodationReservationId;
    }




    public TripOrder setTripOrderEntity(TripOrder tripOrder,User user,Transportation transportation,Trip trip,Object reservation){
        tripOrder.setId(this.getTripOrderId());
        tripOrder.setOrderCreationDate(this.getOrderCreationDate());
        tripOrder.setTotalDueAmount(this.calculateTotalDueAmount(trip));
        tripOrder.setTrip(trip);
        tripOrder.setUser(user);
        tripOrder.setTransportation(transportation);
        tripOrder.setSeats(this.seats);
        String className = reservation.getClass().getName();
        if(reservation.getClass().getName() == "com.shahyasni.persistence.Entities.ReservationType.LodgingBuildingReservation"){
            tripOrder.setLodgingBuildingReservation((LodgingBuildingReservation) reservation);
            tripOrder.setPrivatePropertyReservation(null);
        }else {
            tripOrder.setPrivatePropertyReservation((PrivatePropertyReservation) reservation);
            tripOrder.setLodgingBuildingReservation(null);
        }
        return tripOrder;
    }


    public double calculateTotalDueAmount(Trip trip){
        return this.seats.size() * trip.getPrice();
    }

}

