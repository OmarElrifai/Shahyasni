package com.shahyasni.persistence.DAOs;

import com.shahyasni.persistence.DTOs.LocationDTO;
import com.shahyasni.persistence.DTOs.LodgingBuildingDTO;
import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.Location;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;


@Stateless
public class LodgingBuildingDao implements Serializable {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private LocationDao locationDao;

    public void createLodgingBuilding(LodgingBuildingDTO lodgingBuildingDTO){
        Location location = em.find(Location.class, lodgingBuildingDTO.getLocationId());
        LodgingBuilding lodgingBuilding  = new LodgingBuilding();
        em.persist(lodgingBuildingDTO.toLodgingBuildingEntity(lodgingBuilding,location));
    }

    public List<LodgingBuilding> getLodgingBuilding(String name){
        return em.createQuery("select l from LodgingBuilding l where l.name = :name",LodgingBuilding.class).setParameter("name",name).getResultList();
    }


    public LodgingBuilding updateLodgingBuilding(LodgingBuildingDTO lodgingBuildingDTO){
        Location location = em.find(Location.class, lodgingBuildingDTO.getLocationId());
        LodgingBuilding lodgingBuilding  = em.find(LodgingBuilding.class,lodgingBuildingDTO.getId());
        return em.merge(lodgingBuildingDTO.toLodgingBuildingEntity(lodgingBuilding,location));
    }

    public void removeLodgingBuilding(Integer lodgingBuildingId){
        LodgingBuilding lodgingBuilding = em.find(LodgingBuilding.class, lodgingBuildingId);
        em.remove(lodgingBuilding);
    }



}
