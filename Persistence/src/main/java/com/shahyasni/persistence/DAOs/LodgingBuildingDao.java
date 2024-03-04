package com.shahyasni.persistence.DAOs;

import com.shahyasni.persistence.DTOs.*;
import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.Location;
import com.shahyasni.persistence.Entities.LodgingBuildingBenefits;
import com.shahyasni.persistence.Entities.Owner;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Stateless
public class LodgingBuildingDao implements Serializable {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private LocationDao locationDao;

    public void createLodgingBuilding(LodgingBuildingDTO lodgingBuildingDTO){
        Location location = em.find(Location.class, lodgingBuildingDTO.getLocationId());
        Owner owner = em.find(Owner.class,lodgingBuildingDTO.getOwnerId());
        LodgingBuilding lodgingBuilding  = new LodgingBuilding();
        em.persist(lodgingBuildingDTO.toLodgingBuildingEntity(lodgingBuilding,location,owner));
        List<LodgingBuilding> lodgingBuildingEntity = em.createQuery("select accomodation from LodgingBuilding accomodation where accomodation.name = :name",LodgingBuilding.class).setParameter("name",lodgingBuildingDTO.getName()).getResultList();
        for(LodgingBuildingBenefits lodgingBuildingBenefits : lodgingBuildingDTO.createLodgingBuildingBenefitsEntities(lodgingBuildingEntity.get(0))){
            em.persist(lodgingBuildingBenefits);
        }

    }



    public LodgingBuildingDTO getLodgingBuilding(Integer id){
        return em.createQuery("select  new com.shahyasni.persistence.DTOs.LodgingBuildingDTO(accomodation.id,accomodation.name,accomodation.address,accomodation.singleRoomPrice,accomodation.doubleRoomsPrice,accomodation.tripleRoomsPrice,accomodation.lodgingBuildingType,accomodation.hotelDescription,accomodation.cleanliness,accomodation.roomService,accomodation.reception,accomodation.foodQuality,benefits,owner.id,comments,location) from LodgingBuilding accomodation join accomodation.owner owner join accomodation.location location join accomodation.lodgingBuildingBenefits benefits left join accomodation.comments comments where accomodation.id = :id",LodgingBuildingDTO.class).setParameter("id",id).getSingleResult();
    }
    public List<LodgingBuildingListDTO> getAvailableLodgingBuildings(AccomodationsFilter accomodationsFilter){

        List<LodgingBuildingListDTO> lodgingBuildings = new ArrayList<>();
        Long noOfSingleRooms = accomodationsFilter.getNoOfSingleRooms().longValue();
        Long noOfDoubleRooms = accomodationsFilter.getNoOfDoubleRooms().longValue();
        Long noOfTripleRooms = accomodationsFilter.getNoOfTripleRooms().longValue();

        List<LodgingBuildingListDTO> availableLodgBuildWithNoReservation = em.createQuery("select new com.shahyasni.persistence.DTOs.LodgingBuildingListDTO(accomodation.id,accomodation.name, accomodation.address, accomodation.singleRoomPrice, accomodation.doubleRoomsPrice, accomodation.tripleRoomsPrice,accomodation.lodgingBuildingType, accomodation.hotelDescription,benefits,location,accomodation.rating) from LodgingBuilding accomodation join accomodation.location location join accomodation.lodgingBuildingBenefits benefits join accomodation.owner owner left join accomodation.comments comments where accomodation.lodgingBuildingType = :accomodationType and "
                +"(select count (*) from LodgingBuildingReservation r join r.lodgingBuilding rl where rl.id = accomodation.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate))) = 0 ",LodgingBuildingListDTO.class)
                .setParameter("accomodationType",accomodationsFilter.getLodgingBuildingType())
                .setParameter("filterFromDate",accomodationsFilter.getFromDate())
                .setParameter("filterToDate",accomodationsFilter.getToDate())
                .getResultList();
        lodgingBuildings.addAll(availableLodgBuildWithNoReservation);

        List<LodgingBuildingListDTO> availableLodgBuildWithReservations =  em.createQuery("select new com.shahyasni.persistence.DTOs.LodgingBuildingListDTO(accomodation.id,accomodation.name, accomodation.address, accomodation.singleRoomPrice, accomodation.doubleRoomsPrice, accomodation.tripleRoomsPrice,accomodation.lodgingBuildingType, accomodation.hotelDescription,benefits,location,accomodation.rating) from LodgingBuilding accomodation join accomodation.lodgingBuildingBenefits benefits join accomodation.owner owner join accomodation.location location  left join accomodation.comments comments where accomodation.lodgingBuildingType = :accomodationType and "
                        +"accomodation.singleRoomsMax > (select sum (r.noOfSingleRooms) from LodgingBuildingReservation r join r.lodgingBuilding rl where rl.id = accomodation.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate)))  and "
                        +"accomodation.doubleRoomsMax > (select sum (r.noOfDoubleRooms) from LodgingBuildingReservation r join r.lodgingBuilding rl where rl.id = accomodation.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate))) and "
                        +"accomodation.tripleRoomsMax > (select sum (r.noOfTripleRooms) from LodgingBuildingReservation r join r.lodgingBuilding rl where rl.id = accomodation.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate))) and "
                        +":noOfSingleRooms <= (select accomodation.singleRoomsMax - sum (r.noOfSingleRooms) from LodgingBuildingReservation r join r.lodgingBuilding rl where rl.id = accomodation.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate))) and "
                        +":noOfDoubleRooms <= (select accomodation.doubleRoomsMax - sum (r.noOfDoubleRooms) from LodgingBuildingReservation r join r.lodgingBuilding rl where rl.id = accomodation.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate))) and "
                        +":noOfTripleRooms <= (select accomodation.tripleRoomsMax - sum (r.noOfTripleRooms) from LodgingBuildingReservation r join r.lodgingBuilding rl where rl.id = accomodation.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate)))",LodgingBuildingListDTO.class)
                .setParameter("accomodationType",accomodationsFilter.getLodgingBuildingType())
                .setParameter("noOfSingleRooms",noOfSingleRooms)
                .setParameter("noOfDoubleRooms",noOfDoubleRooms)
                .setParameter("noOfTripleRooms",noOfTripleRooms)
                .setParameter("filterFromDate",accomodationsFilter.getFromDate())
                .setParameter("filterToDate",accomodationsFilter.getToDate())
                .getResultList();
        lodgingBuildings.addAll(availableLodgBuildWithReservations);

        return lodgingBuildings;
    }

    public ReservationAvailability checkAvailability(SearchRequest request){
        ReservationAvailability reservationAvailability = new ReservationAvailability();
        Integer noOfSingleRooms = em.createQuery("select accomodation.singleRoomsMax from LodgingBuilding accomodation where accomodation.id = :id",Integer.class).setParameter("id",request.getAccomodationId()).getSingleResult();
        Integer noOfDoubleRooms = em.createQuery("select accomodation.doubleRoomsMax from LodgingBuilding accomodation where accomodation.id = :id",Integer.class).setParameter("id",request.getAccomodationId()).getSingleResult();
        Integer noOfTripleRooms = em.createQuery("select accomodation.tripleRoomsMax from LodgingBuilding accomodation where accomodation.id = :id",Integer.class).setParameter("id",request.getAccomodationId()).getSingleResult();

        Long totalSingleRoomsReserved = em.createQuery("select sum(r.noOfSingleRooms) from LodgingBuildingReservation r join r.lodgingBuilding accomodation where accomodation.id = :acccomodationId and  ((:requestFrom between r.fromDate and r.toDate) or (:requestTo between r.fromDate and r.toDate)) ", Long.class)
                .setParameter("acccomodationId", request.getAccomodationId())
                .setParameter("requestFrom", request.getFrom())
                .setParameter("requestTo", request.getTo())
                .getSingleResult();


        Long totalDoubleRoomsReserved = em.createQuery("select sum(r.noOfDoubleRooms) from LodgingBuildingReservation r join r.lodgingBuilding accomodation where accomodation.id = :acccomodationId and  ((:requestFrom between r.fromDate and r.toDate) or (:requestTo between r.fromDate and r.toDate)) ",Long.class)
                .setParameter("acccomodationId",request.getAccomodationId())
                .setParameter("requestFrom",request.getFrom())
                .setParameter("requestTo",request.getTo())
                .getSingleResult();

        Long totalTripleRoomsReserved = em.createQuery("select sum(r.noOfDoubleRooms) from LodgingBuildingReservation r join r.lodgingBuilding accomodation where accomodation.id = :acccomodationId and  ((:requestFrom between r.fromDate and r.toDate) or (:requestTo between r.fromDate and r.toDate)) ",Long.class)
                .setParameter("acccomodationId",request.getAccomodationId())
                .setParameter("requestFrom",request.getFrom())
                .setParameter("requestTo",request.getTo())
                .getSingleResult();

        if(totalSingleRoomsReserved == null){
            totalSingleRoomsReserved = 0L;
        }
        if(totalDoubleRoomsReserved == null){
            totalDoubleRoomsReserved = 0L;
        }
        if(totalTripleRoomsReserved == null){
            totalTripleRoomsReserved = 0L;
        }
        reservationAvailability.singleRoomsAvailable = noOfSingleRooms - totalSingleRoomsReserved;
        reservationAvailability.doubleRoomsAvailable = noOfDoubleRooms - totalDoubleRoomsReserved;
        reservationAvailability.tripleRoomsAvailable = noOfTripleRooms - totalTripleRoomsReserved;


        return reservationAvailability;
//        em.createQuery("select accomodation from LodgingBuilding accomodation where accomodation.doubleRoomsMax > (select sum(r.noOfDoubleRooms) from LodgingBuildingReservation r join r.lodgingBuilding accomodation where accomodation.id = :acccomodationId and  ((:requestFrom between r.fromDate and r.toDate) or (:requestTo between r.fromDate and r.toDate))) ",Boolean.class).getSingleResult();
//        em.createQuery("select accomodation from LodgingBuilding accomodation where accomodation.tripleRoomsMax > (select sum(r.noOfTripleRooms) from LodgingBuildingReservation r join r.lodgingBuilding accomodation where accomodation.id = :acccomodationId and  ((:requestFrom between r.fromDate and r.toDate) or (:requestTo between r.fromDate and r.toDate))) ",Boolean.class).getSingleResult();
    }

    public LodgingBuilding updateLodgingBuilding(LodgingBuildingDTO lodgingBuildingDTO){
        Location location = em.find(Location.class, lodgingBuildingDTO.getLocationId());
        Owner owner = em.createQuery("select owner from Owner owner join owner.lodgingBuildings accomodation where accomodation.id = :id",Owner.class).setParameter("id",lodgingBuildingDTO.getId()).getSingleResult();
        LodgingBuilding lodgingBuilding  = em.find(LodgingBuilding.class,lodgingBuildingDTO.getId());
        return em.merge(lodgingBuildingDTO.toLodgingBuildingEntity(lodgingBuilding,location,owner));
    }

    public void removeLodgingBuilding(Integer lodgingBuildingId){
        LodgingBuilding lodgingBuilding = em.find(LodgingBuilding.class, lodgingBuildingId);
        em.createQuery("delete from LodgingBuildingBenefits benefits where benefits.lodgingBuilding.id = :lodgingBuilding").setParameter("lodgingBuilding",lodgingBuilding.getId()).executeUpdate();
        em.createQuery("delete from LodgingBuildingComments comments where comments.lodgingBuilding.id = :lodgingBuilding").setParameter("lodgingBuilding",lodgingBuilding.getId()).executeUpdate();
        em.remove(lodgingBuilding);
    }
//    List<LodgingBuildingBenefits> benefits = em.createQuery("select benefits from LodgingBuildingBenefits benefits join benefits.lodgingBuilding accomodation where accomodation.id = :id",LodgingBuildingBenefits.class).setParameter("id",lodgingBuildingDTO.getId()).getResultList();
//    List<LodgingBuildingBenefits> comments = em.createQuery("select benefits from LodgingBuildingBenefits benefits join benefits.lodgingBuilding accomodation where accomodation.id = :id",LodgingBuildingBenefits.class).setParameter("id",lodgingBuildingDTO.getId()).getResultList();



}
