package com.shahyasni.persistence.Entities.AccomodationTypes;

import com.shahyasni.persistence.Entities.*;
import com.shahyasni.persistence.Entities.CommentsEntities.LodgingBuildingComments;
import com.shahyasni.persistence.Entities.PropertyPhotosEntities.LodgingBuildingPhotos;
import com.shahyasni.persistence.Entities.ReservationType.LodgingBuildingReservation;
import com.shahyasni.persistence.Entities.SupportingDocsEntities.LodgingBuildingDocs;
import com.shahyasni.persistence.Enums.LodgingBuildingType;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class LodgingBuilding{


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "Name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "Owner")
    private Owner owner;

    @OneToMany(mappedBy = "lodgingBuilding")
    @JsonbTransient
    private List<LodgingBuildingDocs> supportingDocuments = new ArrayList<>();

    @OneToMany(mappedBy = "lodgingBuilding")
    @JsonbTransient
    private List<LodgingBuildingPhotos> photos = new ArrayList<>();

    @Column(name = "LodgingBuildingType")
    private LodgingBuildingType lodgingBuildingType;

    @OneToMany(mappedBy = "lodgingBuilding")
    @JsonbTransient
    private List<LodgingBuildingReservation> lodgingBuildingReservations = new ArrayList<>();

    @Embedded
    private LodgingBuildingBenefits lodgingBuildingBenefits;

    @Embedded
    private RoomBenefits roomBenefits;

    @OneToMany(mappedBy = "lodgingBuilding")
    @JsonbTransient
    private List<LodgingBuildingAdditionalBenefits> lodgingBuildingAdditionalBenefits = new ArrayList<>();

    @Column(name = "CheckoutTime")
    private LocalTime checkout;

    @Column(name = "SingleRoomsMax")
    private Integer singleRoomsMax;

    @Column(name = "singleRoomPrice")
    private double singleRoomPrice;
    @Column(name = "DoubleRoomsMax")
    private Integer doubleRoomsMax;

    @Column(name = "DoubleRoomsPrice")
    private double doubleRoomsPrice;

    @Column(name = "TripleRoomsMax")
    private Integer tripleRoomsMax;

    @Column(name = "TripleRoomsPrice")
    private double tripleRoomsPrice;

    @Column(name = "HotelDescription")
    private String hotelDescription;

    @Column(name = "Cleanliness")
    private double cleanliness;

    @Column(name = "RoomServiceEvaluation")
    private double roomService;

    @Column(name = "ReceptionDecency")
    private double reception;

    @Column(name = "FoodQuality")
    private double foodQuality;

    @OneToMany(mappedBy = "lodgingBuilding")
    @JsonbTransient
    private List<LodgingBuildingComments> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Location")
    private Location location;

    @Embedded
    private Address address;

    public LodgingBuilding(){

    }



    public List<LodgingBuildingPhotos> getPhotos() {
        return photos;
    }

    public void setPhotos(List<LodgingBuildingPhotos> photos) {
        this.photos = photos;
    }

    public List<LodgingBuildingDocs> getSupportingDocuments() {
        return supportingDocuments;
    }

    public void setSupportingDocuments(List<LodgingBuildingDocs> supportingDocuments) {
        this.supportingDocuments = supportingDocuments;
    }

    public double getSingleRoomPrice() {
        return singleRoomPrice;
    }

    public void setSingleRoomPrice(double price) {
        this.singleRoomPrice = price;
    }


    public LodgingBuildingBenefits getLodgingBuildingBenefits() {
        return lodgingBuildingBenefits;
    }

    public void setLodgingBuildingBenefits(LodgingBuildingBenefits lodgingBuildingBenefits) {
        this.lodgingBuildingBenefits = lodgingBuildingBenefits;
    }

    public RoomBenefits getRoomBenefits() {
        return roomBenefits;
    }

    public void setRoomBenefits(RoomBenefits roomBenefits) {
        this.roomBenefits = roomBenefits;
    }



    public LocalTime getCheckout() {
        return checkout;
    }

    public void setCheckout(LocalTime checkout) {
        this.checkout = checkout;
    }

    public Integer getSingleRoomsMax() {
        return singleRoomsMax;
    }

    public void setSingleRoomsMax(Integer singleRoomsMax) {
        this.singleRoomsMax = singleRoomsMax;
    }

    public Integer getDoubleRoomsMax() {
        return doubleRoomsMax;
    }

    public void setDoubleRoomsMax(Integer doubleRoomsMax) {
        this.doubleRoomsMax = doubleRoomsMax;
    }

    public Integer getTripleRoomsMax() {
        return tripleRoomsMax;
    }

    public void setTripleRoomsMax(Integer tripleRoomsMax) {
        this.tripleRoomsMax = tripleRoomsMax;
    }

    public String getHotelDescription() {
        return hotelDescription;
    }

    public void setHotelDescription(String hotelDescription) {
        this.hotelDescription = hotelDescription;
    }

    public double getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(double cleanliness) {
        this.cleanliness = cleanliness;
    }

    public double getRoomService() {
        return roomService;
    }

    public void setRoomService(double roomService) {
        this.roomService = roomService;
    }

    public double getReception() {
        return reception;
    }

    public void setReception(double reception) {
        this.reception = reception;
    }

    public double getFoodQuality() {
        return foodQuality;
    }

    public void setFoodQuality(double foodQuality) {
        this.foodQuality = foodQuality;
    }


    public List<LodgingBuildingComments> getComments() {
        return comments;
    }

    public void setComments(List<LodgingBuildingComments> comments) {
        this.comments = comments;
    }

    public LodgingBuildingType getLodgingBuildingType() {
        return lodgingBuildingType;
    }

    public void setLodgingBuildingType(LodgingBuildingType lodgingBuildingType) {
        this.lodgingBuildingType = lodgingBuildingType;
    }

    public List<LodgingBuildingReservation> getLodgingBuildingReservations() {
        return lodgingBuildingReservations;
    }

    public void setLodgingBuildingReservations(List<LodgingBuildingReservation> lodgingBuildingReservations) {
        this.lodgingBuildingReservations = lodgingBuildingReservations;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<LodgingBuildingAdditionalBenefits> getLodgingBuildingAdditionalBenefits() {
        return lodgingBuildingAdditionalBenefits;
    }

    public void setLodgingBuildingAdditionalBenefits(List<LodgingBuildingAdditionalBenefits> lodgingBuildingAdditionalBenefits) {
        this.lodgingBuildingAdditionalBenefits = lodgingBuildingAdditionalBenefits;
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getDoubleRoomsPrice() {
        return doubleRoomsPrice;
    }

    public void setDoubleRoomsPrice(double doubleRoomsPrice) {
        this.doubleRoomsPrice = doubleRoomsPrice;
    }

    public double getTripleRoomsPrice() {
        return tripleRoomsPrice;
    }

    public void setTripleRoomsPrice(double tripleRoomsPrice) {
        this.tripleRoomsPrice = tripleRoomsPrice;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }
}
