package org.example.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 15/02/2023 13:39
Last modified on 13:39
Version 1.0
*/

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TblUnit")
public class Units {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "unitId")
    private Long unitId;

    @ManyToOne
    @JoinColumn(name = "KonsumenID")
    private Konsumen konsumen;

    @Column(name = "NamaUnit",length = 150,nullable = true)
    private String namaUnit;

    @Column(name = "TypeUnit",length = 150,nullable = true)
    private String typeUnit;

    @Column(name = "MerkUnit",length = 50,nullable = true)
    private String merkUnit;

    @Column(name = "JumlahUnit",nullable = true)
    private Integer jumlahUnit;

    @Column(name = "HargaUnit",nullable = true)
    private Integer hargaUnit;

    @Column(name = "createdDate", nullable = true)
    private Date createdDate = new Date();

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Konsumen getKonsumen() {
        return konsumen;
    }

    public void setKonsumen(Konsumen konsumen) {
        this.konsumen = konsumen;
    }

    public String getNamaUnit() {
        return namaUnit;
    }

    public void setNamaUnit(String namaUnit) {
        this.namaUnit = namaUnit;
    }

    public String getTypeUnit() {
        return typeUnit;
    }

    public void setTypeUnit(String typeUnit) {
        this.typeUnit = typeUnit;
    }

    public String getMerkUnit() {
        return merkUnit;
    }

    public void setMerkUnit(String merkUnit) {
        this.merkUnit = merkUnit;
    }

    public Integer getJumlahUnit() {
        return jumlahUnit;
    }

    public void setJumlahUnit(Integer jumlahUnit) {
        this.jumlahUnit = jumlahUnit;
    }

    public Integer getHargaUnit() {
        return hargaUnit;
    }

    public void setHargaUnit(Integer hargaUnit) {
        this.hargaUnit = hargaUnit;
    }
}
