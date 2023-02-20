package org.example.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author widia a.k.a. Widia
Created on 25/01/2023 09:24
Last modified on 09:24
Version 1.0
*/

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "TblDocument")
public class Documents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DocumentId")
    private Long docId;

//    @ManyToOne
//    @JoinColumn(name = "LesseeId")
//    private Lessees lessees;
//
//    @ManyToOne
//    @JoinColumn(name = "FileId")
//    private fileDB fileDB;

    @Column(name = "NamaKonsumen", length = 100, nullable = true)
    private String namaKonsumen;

    @Column(name = "AktePendirian", length = 150, nullable = true)
    private String aktePendirian;

    @Column(name = "KTP", length = 150, nullable = true)
    private String ktp;

    @Column(name = "TDP", length = 150, nullable = true)
    private String tdp;

    @Column(name = "CompPro", length = 150, nullable = true)
    private String compPro;

    @Column(name = "RekKoran", length = 150, nullable = true)
    private String rekKoran;

    @Column(name = "DataModal", length = 150, nullable = true)
    private String dataModal;

    @Column(name = "LapKeuangan", length = 150, nullable = true)
    private String lapKeuangan;

    @Column(name = "PKS",length = 150, nullable = true)
    private String pks;

    @Column(name = "KK",length = 150, nullable = true)
    private String kk;

    @Column(name = "AkteNikah", length = 150, nullable = true)
    private String akteNikah;

    public Long getDocId() {
        return docId;
    }

    public String getNamaKonsumen() {
        return namaKonsumen;
    }

    public void setNamaKonsumen(String namaKonsumen) {
        this.namaKonsumen = namaKonsumen;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public String getAktePendirian() {
        return aktePendirian;
    }

    public void setAktePendirian(String aktePendirian) {
        this.aktePendirian = aktePendirian;
    }

    public String getKtp() {
        return ktp;
    }

    public void setKtp(String ktp) {
        this.ktp = ktp;
    }

    public String getTdp() {
        return tdp;
    }

    public void setTdp(String tdp) {
        this.tdp = tdp;
    }

    public String getCompPro() {
        return compPro;
    }

    public void setCompPro(String compPro) {
        this.compPro = compPro;
    }

    public String getRekKoran() {
        return rekKoran;
    }

    public void setRekKoran(String rekKoran) {
        this.rekKoran = rekKoran;
    }

    public String getDataModal() {
        return dataModal;
    }

    public void setDataModal(String dataModal) {
        this.dataModal = dataModal;
    }

    public String getLapKeuangan() {
        return lapKeuangan;
    }

    public void setLapKeuangan(String lapKeuangan) {
        this.lapKeuangan = lapKeuangan;
    }

    public String getPks() {
        return pks;
    }

    public void setPks(String pks) {
        this.pks = pks;
    }

    public String getKk() {
        return kk;
    }

    public void setKk(String kk) {
        this.kk = kk;
    }

    public String getAkteNikah() {
        return akteNikah;
    }

    public void setAkteNikah(String akteNikah) {
        this.akteNikah = akteNikah;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Column(name = "CreatedDate", nullable = true)
    private Date createdDate = new Date();

    @Column(name = "ModifiedDate", nullable = true)
    private Date modifiedDate;

}
