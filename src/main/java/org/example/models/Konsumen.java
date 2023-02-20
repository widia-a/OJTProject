package org.example.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 15/02/2023 13:40
Last modified on 13:40
Version 1.0
*/


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TblKonsumen")
public class Konsumen {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "konsumenId")
    private Long konsID;

    @Column(name = "NamaKonsumen",length = 150,nullable = true)
    private String namaKonsumen;

    @Column(name = "AlamatUsaha",length = 150,nullable = true)
    private String alamatUsaha;

    @Column(name = "Kota",length = 50,nullable = true)
    private String kota;

    @Column(name = "ContactPerson",length = 50,nullable = true)
    private String contactPerson;

    @Column(name = "Email",length = 50,nullable = true)
    private String email;

    @Column(name = "NoTelp",length = 20,nullable = true)
    private String noTelp;

    @Column(name = "NoHp",length = 20,nullable = true)
    private String noHp;

    @Column(name = "NPWP",length = 20,nullable = true)
    private String npwp;

    @Column(name = "createdDate", nullable = true)
    private Date createdDate = new Date();

    public Long getKonsID() {
        return konsID;
    }

    public String getNamaKonsumen() {
        return namaKonsumen;
    }

    public String getAlamatUsaha() {
        return alamatUsaha;
    }

    public String getKota() {
        return kota;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public String getNoHp() {
        return noHp;
    }

    public String getNpwp() {
        return npwp;
    }

    public Date getCreatedDate() {
        return createdDate;
    }
}
