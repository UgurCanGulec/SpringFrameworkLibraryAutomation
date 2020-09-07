package com.gulecugurcan.service;

import com.gulecugurcan.dao.KitapDao;
import com.gulecugurcan.dao.YayineviDao;
import com.gulecugurcan.model.Kitap;
import com.gulecugurcan.model.Yayinevi;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class KitapService {
    private static final Logger log = Logger.getLogger(YayineviService.class.getName());
    @Autowired
    private KitapDao kitapDao;


    public List<Kitap> kitapListele() {
        return kitapDao.kitapListele();
    }

    public Object kitapGetirId(Long id) {//id yerine ISBN kullanacağız.
        return kitapDao.kitapGetir(Kitap.class, id);
    }

    public Boolean kitapSil(Long kitapISBN) {//kitapID:kitapISBN oluyor

        Kitap kitap = (Kitap) kitapDao.kitapGetir(Kitap.class, kitapISBN);

        return kitapDao.kitapSil(kitap);
    }


    public Boolean kitapEkleGuncelle(Long kitapISBN, String kitapAdi, String kitapYazari,
                                     int kitapSayfa, String kitapTuru, Long yayineviID,MultipartFile kapakResmi) throws IOException {
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");
        Yayinevi yayinevi=(Yayinevi) kitapDao.kitapGetir(Yayinevi.class,yayineviID);//KitapDao sınıfında bulunan kitapgetir metodu generic olduğundan yayinevine ait sınıfı da getirir.
        Kitap kitap = (Kitap) kitapDao.kitapGetir(Kitap.class, kitapISBN);
        byte[] resimbyte=kapakResmi.getBytes();
        if (kitap == null) { //O zaman böyle bir kayıt yok ilk kez eklenecek

            kitap = new Kitap();
            kitap.setKitapISBN(kitapISBN);


        }
        kitap.setKitapAdi(kitapAdi);
        kitap.setKitapYazari(kitapYazari);
        kitap.setKitapSayfa(kitapSayfa);
        kitap.setKitapTuru(kitapTuru);
        kitap.setYayinevi(yayinevi);
        kitap.setKapakSayfasi(resimbyte);
        return kitapDao.kitapEkleGuncelle(kitap);


    }
}
