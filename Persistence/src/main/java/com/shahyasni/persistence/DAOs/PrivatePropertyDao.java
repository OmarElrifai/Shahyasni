package com.shahyasni.persistence.DAOs;

import com.shahyasni.persistence.DTOs.*;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.Location;
import com.shahyasni.persistence.Entities.Owner;
import com.shahyasni.persistence.Entities.PrivatePropertyBenefits;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PrivatePropertyDao implements Serializable {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private LocationDao locationDao;

    public void createPrivateProperty(PrivatePropertyDTO privatePropertyDTO){
        System.out.println("----------------> "+privatePropertyDTO.getLocationId());
        Location location = em.find(Location.class, privatePropertyDTO.getLocationId());
        Owner owner = em.find(Owner.class, privatePropertyDTO.getOwnerId());
        PrivateProperty privateProperty  = new PrivateProperty();
        em.persist(privatePropertyDTO.toPrivatePropertyEntity(privateProperty, owner,location));
        List<PrivateProperty> privatePropertyEntities = em.createQuery("select p from PrivateProperty p where p.name = :name",PrivateProperty.class).setParameter("name",privatePropertyDTO.getName()).getResultList();
        for (PrivatePropertyBenefits privatePropertyBenefits : privatePropertyDTO.createPrivatePropertyBenefitsEntities(privatePropertyEntities.get(0))){
           em.persist(privatePropertyBenefits);
        }
    }

    public PrivatePropertyDTO getPrivateProperty(Integer id){
        return em.createQuery("select  new com.shahyasni.persistence.DTOs.PrivatePropertyDTO(p.id,p.name,p.privatePropertyType, location, p.address,  p.singleRoomPrice,p.doubleRoomsPrice,p.tripleRoomsPrice, benefits,p.rating,comments, owner.id) from PrivateProperty p join p.owner owner join p.location location  join p.benefits benefits left join p.comments comments where p.id = :id", PrivatePropertyDTO.class).setParameter("id",id).getSingleResult();
    }

    public List<PrivatePropertyListDTO> getAvailablePrivateBuilding(AccomodationsFilter accomodationsFilter){

        List<PrivatePropertyListDTO> privateBuildings = new ArrayList<>();
        Long noOfSingleRooms = accomodationsFilter.getNoOfSingleRooms().longValue();
        Long noOfDoubleRooms = accomodationsFilter.getNoOfDoubleRooms().longValue();
        Long noOfTripleRooms = accomodationsFilter.getNoOfTripleRooms().longValue();

        List<PrivatePropertyListDTO> availableLodgBuildWithNoReservation = em.createQuery("select new com.shahyasni.persistence.DTOs.PrivatePropertyListDTO(p.id,p.name,p.privatePropertyType, location, p.address,  p.singleRoomPrice,p.doubleRoomsPrice,p.tripleRoomsPrice, benefits,p.rating) from PrivateProperty p join p.location location  join p.benefits benefits join p.owner owner where p.privatePropertyType = :buildingType and"
                        +"(select count (*) from PrivatePropertyReservation r join r.privateProperty rp where rp.id = p.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate))) = 0 ",PrivatePropertyListDTO.class)
                .setParameter("buildingType",accomodationsFilter.getPrivatePropertyType())
                .setParameter("filterFromDate",accomodationsFilter.getFromDate())
                .setParameter("filterToDate",accomodationsFilter.getToDate())
                .getResultList();
        privateBuildings.addAll(availableLodgBuildWithNoReservation);

        List<PrivatePropertyListDTO> availablePropertyWithReservations =  em.createQuery("select new com.shahyasni.persistence.DTOs.PrivatePropertyListDTO(p.id,p.name,p.privatePropertyType, location, p.address,  p.singleRoomPrice,p.doubleRoomsPrice,p.tripleRoomsPrice, benefits,p.rating) from PrivateProperty p join p.location location  join p.benefits benefits join p.owner owner where p.privatePropertyType = :buildingType and "
                        +"p.singleRoomsMax > (select sum (r.noOfSingleRooms) from PrivatePropertyReservation r join r.privateProperty rp where rp.id = p.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate)))  and "
                        +"p.doubleRoomsMax > (select sum (r.noOfDoubleRooms) from PrivatePropertyReservation r join r.privateProperty rp where rp.id = p.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate))) and "
                        +"p.tripleRoomsMax > (select sum (r.noOfTripleRooms) from PrivatePropertyReservation r join r.privateProperty rp where rp.id = p.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate))) and "
                        +":noOfSingleRooms <= (select p.singleRoomsMax - sum (r.noOfSingleRooms) from PrivatePropertyReservation r join r.privateProperty rp where rp.id = p.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate))) and "
                        +":noOfDoubleRooms <= (select p.doubleRoomsMax - sum (r.noOfDoubleRooms) from PrivatePropertyReservation r join r.privateProperty rp where rp.id = p.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate))) and "
                        +":noOfTripleRooms <= (select p.tripleRoomsMax - sum (r.noOfTripleRooms) from PrivatePropertyReservation r join r.privateProperty rp where rp.id = p.id and ((r.fromDate between :filterFromDate and :filterToDate) or (r.toDate between :filterFromDate and :filterToDate)))",PrivatePropertyListDTO.class)
                .setParameter("buildingType",accomodationsFilter.getPrivatePropertyType())
                .setParameter("noOfSingleRooms",noOfSingleRooms)
                .setParameter("noOfDoubleRooms",noOfDoubleRooms)
                .setParameter("noOfTripleRooms",noOfTripleRooms)
                .setParameter("filterFromDate",accomodationsFilter.getFromDate())
                .setParameter("filterToDate",accomodationsFilter.getToDate())
                .getResultList();
        privateBuildings.addAll(availablePropertyWithReservations);

        return privateBuildings;
    }

    public Boolean checkAvailability(SearchRequest request){
        Long count = em.createQuery("select count(*) from PrivatePropertyReservation reservation join reservation.privateProperty accomodation where accomodation.id = :id and ((:fromDate between reservation.fromDate and reservation.toDate) or (:toDate between reservation.fromDate and reservation.toDate))",Long.class).setParameter("id",request.getAccomodationId()).setParameter("fromDate",request.getFrom()).setParameter("toDate",request.getTo()).getSingleResult();
        return count == 0;
    }


    public PrivateProperty updatePrivateProperty(PrivatePropertyDTO privatePropertyDTO){
        Location location = em.find(Location.class, privatePropertyDTO.getLocationId());
        Owner owner = em.createQuery("select owner from Owner owner join owner.privateProperties accomodation where accomodation.id = :id",Owner.class).setParameter("id",privatePropertyDTO.getId()).getSingleResult();
        PrivateProperty privateProperty  = em.find(PrivateProperty.class,privatePropertyDTO.getId());
        return em.merge(privatePropertyDTO.toPrivatePropertyEntity(privateProperty, owner,location));
    }

    public void removePrivateProperty(Integer privatePropertyId){
        PrivateProperty privateProperty = em.find(PrivateProperty.class, privatePropertyId);
        em.createQuery("delete from PrivatePropertyBenefits benefits where benefits.property.id = :property").setParameter("property",privateProperty.getId()).executeUpdate();
        em.createQuery("delete from PrivatePropertyComments comments where comments.property.id = :property").setParameter("property",privateProperty.getId()).executeUpdate();
        em.remove(privateProperty);
    }


}
