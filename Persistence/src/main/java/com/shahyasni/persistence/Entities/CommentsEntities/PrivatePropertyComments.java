package com.shahyasni.persistence.Entities.CommentsEntities;

import com.shahyasni.persistence.Entities.Comments;
import com.shahyasni.persistence.Entities.PropertyTypes.PrivateProperty;
import com.shahyasni.persistence.Entities.User;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class PrivatePropertyComments extends Comments {


    @ManyToOne
    @JoinColumn(name = "UserID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "PropertyID")
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
