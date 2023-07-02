package com.shahyasni.persistence.Entities.CommentsEntities;

import com.shahyasni.persistence.Entities.Comments;
import com.shahyasni.persistence.Entities.PropertyTypes.LodgingBuilding;
import com.shahyasni.persistence.Entities.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class LodgingBuildingComments extends Comments {



    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "LodgingBuildingID")
    private LodgingBuilding lodgingBuilding;


    public User getUser() {
        return user;
    }

    public void setUserID(User userID) {
        this.user = user;
    }


    public LodgingBuilding getLodgingBuilding() {
        return lodgingBuilding;
    }

    public void setLodgingBuilding(LodgingBuilding lodgingBuilding) {
        this.lodgingBuilding = lodgingBuilding;
    }
}
