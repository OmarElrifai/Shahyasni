package com.shahyasni.persistence.Entities.CommentsEntities;

import com.shahyasni.persistence.Entities.Comments;
import com.shahyasni.persistence.Entities.AccomodationTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.User;

import javax.persistence.*;

@Entity
public class LodgingBuildingComments extends Comments {



    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "LodgingBuilding")
    private LodgingBuilding lodgingBuilding;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public LodgingBuilding getLodgingBuilding() {
        return lodgingBuilding;
    }

    public void setLodgingBuilding(LodgingBuilding lodgingBuilding) {
        this.lodgingBuilding = lodgingBuilding;
    }
}
