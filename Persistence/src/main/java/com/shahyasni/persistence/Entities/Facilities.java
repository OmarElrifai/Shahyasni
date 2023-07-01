package com.shahyasni.persistence.Entities;


import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Facilities {
    @Column(name = "FreeWifi")
    private boolean freeWifi;

    @Column(name = "FreeParkingLot")
    private boolean freeParkingLot;

    @Column(name = "AirportShuttle")
    private boolean airportShuttle;

    @Column(name = "FamilyRooms")
    private boolean familyRooms;

    @Column(name = "RoomService")
    private boolean roomService;

    @Column(name = "NonSmokingRooms")
    private boolean nonSmokingRooms;

    public boolean isFreeWifi() {
        return freeWifi;
    }

    public void setFreeWifi(boolean freeWifi) {
        this.freeWifi = freeWifi;
    }

    public boolean isFreeParkingLot() {
        return freeParkingLot;
    }

    public void setFreeParkingLot(boolean freeParkingLot) {
        this.freeParkingLot = freeParkingLot;
    }

    public boolean isAirportShuttle() {
        return airportShuttle;
    }

    public void setAirportShuttle(boolean airportShuttle) {
        this.airportShuttle = airportShuttle;
    }

    public boolean isFamilyRooms() {
        return familyRooms;
    }

    public void setFamilyRooms(boolean familyRooms) {
        this.familyRooms = familyRooms;
    }

    public boolean isRoomService() {
        return roomService;
    }

    public void setRoomService(boolean roomService) {
        this.roomService = roomService;
    }

    public boolean isNonSmokingRooms() {
        return nonSmokingRooms;
    }

    public void setNonSmokingRooms(boolean nonSmokingRooms) {
        this.nonSmokingRooms = nonSmokingRooms;
    }
}
