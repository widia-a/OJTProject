package org.example.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 09:31
Last modified on 09:31
Version 1.0
*/

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

//@Data
@Entity
@Table(name = "TblLessee")
public class Lessees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LesseeId")
    private Long lesseeId;

    @Column(name = "NamaLessee",length = 150,nullable = true)
    private String namaLessee;

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

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getLesseeId() {
        return lesseeId;
    }

    public void setLesseeId(Long lesseeId) {
        this.lesseeId = lesseeId;
    }

    public String getNamaLessee() {
        return namaLessee;
    }

    public void setNamaLessee(String namaLessee) {
        this.namaLessee = namaLessee;
    }

    public String getAlamatUsaha() {
        return alamatUsaha;
    }

    public void setAlamatUsaha(String alamatUsaha) {
        this.alamatUsaha = alamatUsaha;
    }

    public String getKota() {
        return kota;
    }

    public void setKota(String kota) {
        this.kota = kota;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoTelp() {
        return noTelp;
    }

    public void setNoTelp(String noTelp) {
        this.noTelp = noTelp;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getNpwp() {
        return npwp;
    }

    public void setNpwp(String npwp) {
        this.npwp = npwp;
    }
}
