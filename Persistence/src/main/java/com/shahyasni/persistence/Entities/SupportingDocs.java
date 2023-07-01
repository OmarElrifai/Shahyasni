package com.shahyasni.persistence.Entities;

import com.shahyasni.persistence.Enums.SupportingDocType;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class SupportingDocs implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "SupportingDocType")
    private SupportingDocType supportingDocType;

    @Lob
    @Column(name = "DocumentContent")
    private byte[] documentContent;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SupportingDocType getDocumentType() {
        return supportingDocType;
    }

    public void setDocumentType(SupportingDocType supportingDocType) {
        this.supportingDocType = supportingDocType;
    }

    public byte[] getDocumentContent() { return documentContent; }

    public void setDocumentContent(byte[] documentContent) {
        this.documentContent = documentContent;
    }


}
