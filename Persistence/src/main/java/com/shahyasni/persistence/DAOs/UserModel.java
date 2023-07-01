package com.shahyasni.persistence.DAOs;

import com.shahyasni.persistence.Entities.User;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.List;

@Stateless
public class UserModel implements Serializable{
     @PersistenceContext
    private EntityManager em;

    public void insert(User User){
        try {
            em.persist(User);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public List<User> findAll(){

        Query allUsers = em.createNativeQuery("SELECT * FROM User", User.class);
        return (List<User>) allUsers.getResultList() ;
    }
    public User findUserByID(Integer  ID){
        return em.find(User.class, ID);
    }

    public User findUserByUsername(String username){
        Query query = em.createNativeQuery("SELECT * FROM User WHERE Username = '"+ username + "'",User.class);
        return (User) query.getSingleResult();
    }
    public User Update(User User){
       return em.merge(User);
    }
    public void Delete(Integer id){
        User User = em.find(User.class, id);
        em.remove(User);
    }
}
