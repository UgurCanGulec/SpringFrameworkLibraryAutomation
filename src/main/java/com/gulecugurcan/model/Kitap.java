package com.gulecugurcan.model;


import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.persistence.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.sql.Blob;

@Entity
@Table(name = "kitap")
public class Kitap implements Serializable {
         @Id
    @Column(name = "kitapISBN",nullable = false)
    private Long kitapISBN;
    @Column(name = "kitapAdi",nullable = false)
    private String kitapAdi;
    @Column(name = "kitapYazari",nullable = false)
    private String kitapYazari;
    @Column(name = "kitapSayfa",nullable = false)
    private int kitapSayfa;
    @Column(name = "kitapTuru",nullable = false)
    private String kitapTuru;
    @ManyToOne
    @JoinColumn(name = "yayineviID_fk",referencedColumnName = "yayineviID")
    /*name bizim kitap tablomuzdaki alanı,referencedColumnName de yayinevi tablosundaki primaryKey kısmıdır(isimler aynı olmalı)*/
    //Kitap entitisinde yayınevi ile ilgili alan
    private Yayinevi yayinevi;//yayinevi alanı ile mappedBy da ki alan eşleşemesi gerekir
  @Column(name = "kapakSayfasi",columnDefinition = "BLOB")
  private byte[] kapakSayfasi;

    public byte[] getKapakSayfasi() {
        return kapakSayfasi;
    }

    public void setKapakSayfasi(byte[] kapakSayfasi) {
        this.kapakSayfasi = kapakSayfasi;
    }

    public Long getKitapISBN() {
        return kitapISBN;
    }

    public void setKitapISBN(Long kitapISBN) {
        this.kitapISBN = kitapISBN;
    }

    public String getKitapAdi() {
        return kitapAdi;
    }

    public void setKitapAdi(String kitapAdi) {
        this.kitapAdi = kitapAdi;
    }

    public String getKitapYazari() {
        return kitapYazari;
    }

    public void setKitapYazari(String kitapYazari) {
        this.kitapYazari = kitapYazari;
    }

    public int getKitapSayfa() {
        return kitapSayfa;
    }

    public void setKitapSayfa(int kitapSayfa) {
        this.kitapSayfa = kitapSayfa;
    }

    public String getKitapTuru() {
        return kitapTuru;
    }

    public void setKitapTuru(String kitapTuru) {
        this.kitapTuru = kitapTuru;
    }

    public Yayinevi getYayinevi() {
        return yayinevi;
    }

    public void setYayinevi(Yayinevi yayinevi) {
        this.yayinevi = yayinevi;
    }
}
