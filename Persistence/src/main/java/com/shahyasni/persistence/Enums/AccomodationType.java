package com.shahyasni.persistence.Enums;

public enum AccomodationType {
    lodgingBuilding("Lodging Building"),
    privateProperty("Private Building");
    private String acc;

    AccomodationType(String acc){
        this.acc = acc;
    }

    public String getAcc() {
        return acc;
    }
}
