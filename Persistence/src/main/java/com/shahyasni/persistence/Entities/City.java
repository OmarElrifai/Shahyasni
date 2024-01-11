package com.shahyasni.persistence.Entities;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class City implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "name")
    private String name;


    @ManyToOne
    @JoinColumn(name = "Governerate")
    private Governerate governerate;

    @OneToMany(mappedBy = "city")
    @JsonbTransient
    private List<Location> locations;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Governerate getGovernerate() {
        return governerate;
    }

    public void setGovernerate(Governerate governerate) {
        this.governerate = governerate;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public void setLocations(List<Location> locations) {
        this.locations = locations;
    }
}
