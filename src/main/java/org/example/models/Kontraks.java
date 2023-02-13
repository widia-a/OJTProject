package org.example.models;
/*
Created by IntelliJ IDEA 2022.2.3 (Community Edition)
Build #IC-222.4345.14, built on October 5, 2022
@Author DELL a.k.a. Widia
Created on 08/02/2023 13:32
Last modified on 13:32
Version 1.0
*/

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "TblKontrak")
public class Kontraks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KontrakId")
    private Long kontrakId;

    @Column(name = "NoKontrak",length = 10,nullable = true)
    private String noKontrak;

    @Column(name = "JenisAplikasi",length = 150,nullable = true)
    private String jenisAplikasi;

    @Column(name = "NoJadwal",length = 5,nullable = true)
    private String noJadwal;

    @Column(name = "NamaSupplier",length = 150,nullable = true)
    private String namaSup;

    @Column(name = "AlamatSupplier",length = 150,nullable = true)
    private String alamatSup;

    @Column(name = "PicSupplier",length = 150,nullable = true)
    private String picSup;

    @Column(name = "NamaKonsumen",length = 150,nullable = true)
    private String namaKons;

    @Column(name = "AlamatKonsumen",length = 150,nullable = true)
    private String alamatKons;

    @Column(name = "kedudukanKonsumen",length = 150,nullable = true)
    private String kedudukanKons;

    @Column(name = "NamaUnit",length = 150,nullable = true)
    private String unit;

    @Column(name = "MerkUnit",length = 150,nullable = true)
    private String merkUnit;

    @Column(name = "TipeUnit",length = 150,nullable = true)
    private String tipeUnit;

    @Column(name = "JumlahUnit",length = 150,nullable = true)
    private String jumlahUnit;

    @Column(name = "HargaUnit",length = 150,nullable = true)
    private String hargaUnit;

    @Column(name = "PenempatanBarang",length = 150,nullable = true)
    private String penempatan;

    @Column(name = "JumlahFasilitas",length = 150,nullable = true)
    private String jumlahFasilitas;

    @Column(name = "Terbilang",length = 150,nullable = true)
    private String terbilang;

    @Column(name = "NilaiSisa",length = 150,nullable = true)
    private String nilaiSisa;

    @Column(name = "SisaTerbliang",length = 150,nullable = true)
    private String sisaTerbilang;

    @Column(name = "NilaiPembiayaan",length = 150,nullable = true)
    private String nilaiPembiayaan;

    @Column(name = "Tenor",length = 150,nullable = true)
    private String tenor;

    @Column(name = "TenorTerbilang",length = 150,nullable = true)
    private String tenorTerbilang;

    @Column(name = "PersenBiaya", nullable = true)
    private Float persenBiaya;

    @Column(name = "PersenHarga", nullable = true)
    private Float persenHarga;

    @Column(name = "TitleSigner",length = 10,nullable = true)
    private String titleSigner;

    @Column(name = "NamaSigner",length = 150,nullable = true)
    private String namaSigner;

    @Column(name = "JabatanSigner",length = 150,nullable = true)
    private String jabatanSigner;

    @Column(name = "createdDate", nullable = false)
    private Date createdDate = new Date();

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Long getKontrakId() {
        return kontrakId;
    }

    public void setKontrakId(Long kontrakId) {
        this.kontrakId = kontrakId;
    }

    public String getNoKontrak() {
        return noKontrak;
    }

    public void setNoKontrak(String noKontrak) {
        this.noKontrak = noKontrak;
    }

    public String getJenisAplikasi() {
        return jenisAplikasi;
    }

    public void setJenisAplikasi(String jenisAplikasi) {
        this.jenisAplikasi = jenisAplikasi;
    }

    public String getNoJadwal() {
        return noJadwal;
    }

    public void setNoJadwal(String noJadwal) {
        this.noJadwal = noJadwal;
    }

    public String getNamaSup() {
        return namaSup;
    }

    public void setNamaSup(String namaSup) {
        this.namaSup = namaSup;
    }

    public String getAlamatSup() {
        return alamatSup;
    }

    public void setAlamatSup(String alamatSup) {
        this.alamatSup = alamatSup;
    }

    public String getPicSup() {
        return picSup;
    }

    public void setPicSup(String picSup) {
        this.picSup = picSup;
    }

    public String getNamaKons() {
        return namaKons;
    }

    public void setNamaKons(String namaKons) {
        this.namaKons = namaKons;
    }

    public String getAlamatKons() {
        return alamatKons;
    }

    public void setAlamatKons(String alamatKons) {
        this.alamatKons = alamatKons;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getMerkUnit() {
        return merkUnit;
    }

    public void setMerkUnit(String merkUnit) {
        this.merkUnit = merkUnit;
    }

    public String getTipeUnit() {
        return tipeUnit;
    }

    public void setTipeUnit(String tipeUnit) {
        this.tipeUnit = tipeUnit;
    }

    public String getJumlahUnit() {
        return jumlahUnit;
    }

    public void setJumlahUnit(String jumlahUnit) {
        this.jumlahUnit = jumlahUnit;
    }

    public String getHargaUnit() {
        return hargaUnit;
    }

    public void setHargaUnit(String hargaUnit) {
        this.hargaUnit = hargaUnit;
    }

    public String getPenempatan() {
        return penempatan;
    }

    public void setPenempatan(String penempatan) {
        this.penempatan = penempatan;
    }

    public String getJumlahFasilitas() {
        return jumlahFasilitas;
    }

    public void setJumlahFasilitas(String jumlahFasilitas) {
        this.jumlahFasilitas = jumlahFasilitas;
    }

    public String getTerbilang() {
        return terbilang;
    }

    public void setTerbilang(String terbilang) {
        this.terbilang = terbilang;
    }

    public String getNilaiSisa() {
        return nilaiSisa;
    }

    public void setNilaiSisa(String nilaiSisa) {
        this.nilaiSisa = nilaiSisa;
    }

    public String getSisaTerbilang() {
        return sisaTerbilang;
    }

    public void setSisaTerbilang(String sisaTerbilang) {
        this.sisaTerbilang = sisaTerbilang;
    }

    public String getNilaiPembiayaan() {
        return nilaiPembiayaan;
    }

    public void setNilaiPembiayaan(String nilaiPembiayaan) {
        this.nilaiPembiayaan = nilaiPembiayaan;
    }

    public String getTenor() {
        return tenor;
    }

    public void setTenor(String tenor) {
        this.tenor = tenor;
    }

    public String getTenorTerbilang() {
        return tenorTerbilang;
    }

    public void setTenorTerbilang(String tenorTerbilang) {
        this.tenorTerbilang = tenorTerbilang;
    }

    public Float getPersenBiaya() {
        return persenBiaya;
    }

    public void setPersenBiaya(Float persenBiaya) {
        this.persenBiaya = persenBiaya;
    }

    public Float getPersenHarga() {
        return persenHarga;
    }

    public void setPersenHarga(Float persenHarga) {
        this.persenHarga = persenHarga;
    }

    public String getTitleSigner() {
        return titleSigner;
    }

    public void setTitleSigner(String titleSigner) {
        this.titleSigner = titleSigner;
    }

    public String getNamaSigner() {
        return namaSigner;
    }

    public void setNamaSigner(String namaSigner) {
        this.namaSigner = namaSigner;
    }

    public String getJabatanSigner() {
        return jabatanSigner;
    }

    public void setJabatanSigner(String jabatanSigner) {
        this.jabatanSigner = jabatanSigner;
    }

    public String getKedudukanKons() {
        return kedudukanKons;
    }

    public void setKedudukanKons(String kedudukanKons) {
        this.kedudukanKons = kedudukanKons;
    }
}
