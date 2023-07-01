package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class PropertyPhotos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "Photo")
    private byte[] photos;


    public Integer getId() { return id; }
    public byte[] getPhotos() { return photos; }



    public void setId(Integer id) {
        this.id = id;
    }

    public void setPhotos(byte[] photos) {
        this.photos = photos;
    }
}
