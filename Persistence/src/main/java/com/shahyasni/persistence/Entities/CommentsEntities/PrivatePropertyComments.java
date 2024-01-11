package com.shahyasni.persistence.Entities.CommentsEntities;

import com.shahyasni.persistence.Entities.Comments;
import com.shahyasni.persistence.Entities.AccomodationTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.User;

import javax.persistence.*;

@Entity
public class PrivatePropertyComments extends Comments {


    @ManyToOne
    @JoinColumn(name = "User")
    private User user;

    @ManyToOne
    @JoinColumn(name = "Property")
    private PrivateProperty property;




    public PrivateProperty getProperty() {
        return property;
    }

    public void setProperty(PrivateProperty property) {
        this.property = property;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
