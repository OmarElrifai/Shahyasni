package com.shahyasni.persistence.Enums;

public enum SupportingDocType {
    NationalID("National ID") ,
    PropertyContract("Property Contract"),
    CommercialRegister("Commercial Register"),
    OperatingLicense("Operating License"),
    PromotingAndMarketingLicense("Promoting And Marketing License");

    private String supportingDocs;

    SupportingDocType(String supportingDocs){
        this.supportingDocs = supportingDocs;
    }
    public String getSupportingDocs() {
        return supportingDocs;
    }
}
