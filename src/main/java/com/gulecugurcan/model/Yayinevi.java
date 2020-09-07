package com.gulecugurcan.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "yayinevi")
public class Yayinevi implements Serializable {

    @Id
    @Column(name = "yayineviID", nullable = false)
    private Long yayineviID;
    @Column(name = "yayineviAdi", nullable = false)
    private String yayineviAdi;
    @Column(name = "yayineviSehri", nullable = false)
    private String yayineviSehri;
    @Column(name = "yayineviMail", nullable = false)
    private String yayineviMail;
    @Column(name = "yayineviTelefon", nullable = false)
    private String yayineviTelefon;

    @OneToMany(mappedBy = "yayinevi", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    //Yukarıdaki kullanım ile Foreign key bağlı nesneleri çekebiliriz.
    //Yayinevi  kitaplarına ulamak istersek aşağıdaki kullanım kullanılır
    private List<Kitap> kitapList;//Bunun getter metodu tetiklendiğinde ilgili kısımlar çekilecek anlamında
    /*cascade: birbiri ile ilişkili alanların nasıl yönetileceği,CascadeType.All:Bu ilişkilerin tamamı ile foreign key bağlı tabloyu
     *  yani o nesneyi etkilemesini istersek bunu sececeğiz. orphanRemoval=false ya da true olması:ilgili foreign key bağlantılı sınıfda
     * ilgili foreignkey bağlantısı üzerinden ilgili foreign key'e baglı bir sınıf üzerinden bir nesne kalmadıysa ilgiliforeign key bağlantılı
     *  nesnenin silinmesidir*/


    public Long getYayineviID() {
        return yayineviID;
    }

    public Long setYayineviID(Long yayineviID) {
        this.yayineviID = yayineviID;
        return yayineviID;
    }

    public String getYayineviAdi() {
        return yayineviAdi;
    }

    public String setYayineviAdi(String yayineviAdi) {
        this.yayineviAdi = yayineviAdi;
        return yayineviAdi;
    }

    public String getYayineviSehri() {
        return yayineviSehri;
    }

    public String setYayineviSehri(String yayineviSehri) {
        this.yayineviSehri = yayineviSehri;
        return yayineviSehri;
    }

    public String getYayineviMail() {
        return yayineviMail;
    }

    public String setYayineviMail(String yayineviMail) {
        this.yayineviMail = yayineviMail;
        return yayineviMail;
    }

    public String getYayineviTelefon() {
        return yayineviTelefon;
    }

    public String setYayineviTelefon(String yayineviTelefon) {
        this.yayineviTelefon = yayineviTelefon;
        return yayineviTelefon;
    }
}
