package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Entities.PropertyTypes.LodgingBuilding;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class Comments implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String id;


    @Column(name = "Comment")
    private String Comment;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }
}
