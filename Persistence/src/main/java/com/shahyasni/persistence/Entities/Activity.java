package com.shahyasni.persistence.Entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Activity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany
    @JoinTable(name = "ActivityLocations",joinColumns = @JoinColumn(name = "Activity"),inverseJoinColumns = @JoinColumn(name = "Location"))
    private List<Location> locations;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}

