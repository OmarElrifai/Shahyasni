package com.shahyasni.persistence.DAOs;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.shahyasni.persistence.DTOs.*;
import com.shahyasni.persistence.Entities.Activity;
import com.shahyasni.persistence.Entities.City;
import com.shahyasni.persistence.Entities.Location;
import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.Trip;

import java.io.Serializable;
import java.util.List;


@Stateless
public class LocationDao implements Serializable {

    @PersistenceContext
    private EntityManager em;

    public void createLocation(LocationDTO locationDTO){
        Location location = new Location();
        City city = em.find(City.class,locationDTO.getCityId());
        em.persist(locationDTO.toLocationEntity(location,city));
    }

    public List<Object[]> getLocations(String activity){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.LocationDTO(city.name,l.sight,governerate.name) from Activity activity join activity.locations l join l.city city join city.governerate governerate where activity.name = :activity",Object[].class).setParameter("activity",activity).getResultList();
    }



    public List<LodgingBuildingListDTO> getLodgingBuildings(SearchRequest searchRequest){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.LodgingBuildingListDTO(accomodation.id,accomodation.name, accomodation.address, accomodation.singleRoomPrice, accomodation.doubleRoomsPrice, accomodation.tripleRoomsPrice,accomodation.lodgingBuildingType, accomodation.hotelDescription,benefits,location,accomodation.rating) from LodgingBuilding accomodation join accomodation.location location join accomodation.lodgingBuildingBenefits benefits left join accomodation.comments comments  where location.city.name = :city and location.sight = :sight", LodgingBuildingListDTO.class).setParameter("city",searchRequest.getCity()).setParameter("sight",searchRequest.getSight()).getResultList();
    }

    public List<PrivatePropertyListDTO> getPrivateProperty(SearchRequest searchRequest){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.PrivatePropertyListDTO(accomodation.id,accomodation.name ,accomodation.privatePropertyType, location ,accomodation.address, accomodation.singleRoomPrice,accomodation.doubleRoomsPrice,accomodation.tripleRoomsPrice,benefits,accomodation.rating) from PrivateProperty accomodation join accomodation.location location left join accomodation.comments comments join accomodation.benefits benefits join location.city city where city.name = :city  and location.sight = :sight", PrivatePropertyListDTO.class).setParameter("city",searchRequest.getCity()).setParameter("sight",searchRequest.getSight()).getResultList();
    }

    public List<String> getActivities(SearchRequest searchRequest){
        return em.createQuery("select activity.name from Activity activity join activity.locations location where location.city.name = :city  and location.sight = :sight", String.class).setParameter("city",searchRequest.getCity()).setParameter("sight",searchRequest.getSight()).getResultList();
    }

    public Location updateLocation(LocationDTO locationDTO){
        City city = em.find(City.class, locationDTO.getCityId());
        Location location = em.find(Location.class,locationDTO.getId());
        return em.merge(locationDTO.toLocationEntity(location,city));
    }

    public void removeLocation(Integer id){
        Location location = em.find(Location.class,id);
        em.remove(location);
    }


}
