package com.shahyasni.persistence.DAOs;

import com.shahyasni.persistence.DTOs.PrivatePropertyDTO;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.Location;
import com.shahyasni.persistence.Entities.Owner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class PrivatePropertyDao {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private LocationDao locationDao;

    public void createLodgingBuilding(PrivatePropertyDTO privatePropertyDTO){
        Location location = em.find(Location.class, privatePropertyDTO.getLocationId());
        Owner owner = em.find(Owner.class, privatePropertyDTO.getPropertyOwnerId());
        PrivateProperty privateProperty  = new PrivateProperty();
        em.persist(privatePropertyDTO.toPrivatePropertyEntity(privateProperty, owner,location));
    }

//    public List<PrivateProperty> getLodgingBuilding(String name){
//        return em.createQuery("select l from LodgingBuilding l where l.name = :name",LodgingBuilding.class).setParameter("name",name).getResultList();
//    }


    public PrivateProperty updatePrivateProperty(PrivatePropertyDTO privatePropertyDTO){
        Location location = em.find(Location.class, privatePropertyDTO.getLocationId());
        Owner owner = em.find(Owner.class, privatePropertyDTO.getPropertyOwnerId());
        PrivateProperty privateProperty  = em.find(PrivateProperty.class,privatePropertyDTO.getId());
        return em.merge(privatePropertyDTO.toPrivatePropertyEntity(privateProperty, owner,location));
    }

    public void removePrivateProperty(Integer privatePropertyId){
        PrivateProperty privateProperty = em.find(PrivateProperty.class, privatePropertyId);
        em.remove(privateProperty);
    }


}
