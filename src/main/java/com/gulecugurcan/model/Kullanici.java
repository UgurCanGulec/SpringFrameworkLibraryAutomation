package com.gulecugurcan.model;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table
public class Kullanici implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long kullaniciID;

    @Column(nullable = false)
    private String kulllaniciIsimSoyisim;

    @Column(nullable = false)
    private String kullaniciEmail;

    @Column(nullable = false)
    private String kullaniciParola;

    @Column(nullable = false)
    private String kullaniciTelefon;

    public Long getKullaniciID() {
        return kullaniciID;
    }

    public Long setKullaniciID(Long kullaniciID) {
        this.kullaniciID = kullaniciID;
        return kullaniciID;
    }

    public String getKulllaniciIsimSoyisim() {
        return kulllaniciIsimSoyisim;
    }

    public String setKulllaniciIsimSoyisim(String kulllaniciIsimSoyisim) {
        this.kulllaniciIsimSoyisim = kulllaniciIsimSoyisim;
        return kulllaniciIsimSoyisim;
    }

    public String getKullaniciEmail() {
        return kullaniciEmail;
    }

    public String setKullaniciEmail(String kullaniciEmail) {
        this.kullaniciEmail = kullaniciEmail;
        return kullaniciEmail;
    }

    public String getKullaniciParola() {
        return kullaniciParola;
    }

    public String setKullaniciParola(String kullaniciParola) {
        this.kullaniciParola = kullaniciParola;
        return kullaniciParola;
    }

    public String getKullaniciTelefon() {
        return kullaniciTelefon;
    }

    public String setKullaniciTelefon(String kullaniciTelefon) {
        this.kullaniciTelefon = kullaniciTelefon;
        return kullaniciTelefon;
    }
}

