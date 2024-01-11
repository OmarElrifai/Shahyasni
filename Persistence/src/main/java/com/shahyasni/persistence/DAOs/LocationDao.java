package com.shahyasni.persistence.DAOs;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.shahyasni.persistence.DTOs.LocationDTO;
import com.shahyasni.persistence.DTOs.SearchRequest;
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

//     public List<Object[]> getTrips(SearchRequest searchRequest){
//        return em.createQuery("select new com.shahyasni.persistence.DTOs.TripDTO(t.tripTitle,activityLocation.sight,activity.name,t.price) from Trip t join t.locations l join t.activities activity  join activity.locations activityLocation  where l.city.name = :city and l.sight = :sight",Object[].class).setParameter("city",searchRequest.getCity()).setParameter("sight",searchRequest.getSight()).getResultList();
//    }

    public List<Object[]> getLodgingBuildings(SearchRequest searchRequest){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.LodgingBuildingDTO(accomodation.name, accomodation.address, accomodation.singleRoomPrice, accomodation.lodgingBuildingType, accomodation.hotelDescription, accomodation.cleanliness, accomodation.roomService, accomodation.reception, accomodation.foodQuality) from LodgingBuilding accomodation join accomodation.location l where l.city.name = :city and l.sight = :sight",Object[].class).setParameter("city",searchRequest.getCity()).setParameter("sight",searchRequest.getSight()).getResultList();
    }

    public List<Object[]> getPrivateProperty(SearchRequest searchRequest){
        return em.createQuery("select new com.shahyasni.persistence.DTOs.PrivatePropertyDTO(accomodation.buildingType , accomodation.address, accomodation.singleRoomPrice,accomodation.rating, accomodation.singleRoomsMax) from PrivateProperty accomodation join accomodation.location l where l.city.name = :city  and l.sight = :sight", Object[].class).setParameter("city",searchRequest.getCity()).setParameter("sight",searchRequest.getSight()).getResultList();
    }

    public List<String> getActivities(SearchRequest searchRequest){
        return em.createQuery("select activity.name from Activity activity join activity.locations l where l.city.name = :city  and l.sight = :sight", String.class).setParameter("city",searchRequest.getCity()).setParameter("sight",searchRequest.getSight()).getResultList();
    }

    public Location updateLocation(LocationDTO locationDTO){
        City city = em.find(City.class, locationDTO.getCityId());
        Location location = em.find(Location.class,locationDTO.getId());
        return em.merge(locationDTO.toLocationEntity(location,city));
    }


}
