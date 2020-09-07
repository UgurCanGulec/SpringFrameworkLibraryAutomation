package com.gulecugurcan.service;

import com.gulecugurcan.dao.KullaniciDao;
import com.gulecugurcan.dao.YayineviDao;
import com.gulecugurcan.model.Yayinevi;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, rollbackFor = Exception.class)
public class YayineviService {
    private static final Logger log = Logger.getLogger(YayineviService.class.getName());
    @Autowired
    private YayineviDao yayineviDao;

    public List<Yayinevi> yayineviListele() {
        return yayineviDao.yayineviListele();
    }

    public Object yayineviGetirId(Long id) {
        return yayineviDao.yayineviGetir(Yayinevi.class, id);
    }

    public Boolean yayineviSil(Long yayineviID) {
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");
        log.info("Yayinevi silindi: "+yayineviID);
        Yayinevi yayinevi = (Yayinevi) yayineviDao.yayineviGetir(Yayinevi.class, yayineviID);

        return yayineviDao.yayineviSil(yayinevi);
    }


    public Boolean yayineviEkleGuncelle(Long yayineviID, String yayineviAdi, String yayineviSehri,
                                        String yayineviMail, String yayineviTelefon) {
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");

        Yayinevi yayinevi = (Yayinevi) yayineviDao.yayineviGetir(Yayinevi.class, yayineviID);
        if (yayinevi == null) { //O zaman böyle bir kayıt yok ilk kez eklenecek

            yayinevi = new Yayinevi();
            yayinevi.setYayineviID(yayineviID);
            log.info(yayinevi.getYayineviAdi()+" adli yayievi kaydi basarili");

        }
        yayinevi.setYayineviAdi(yayineviAdi);
        yayinevi.setYayineviSehri(yayineviSehri);
        yayinevi.setYayineviMail(yayineviMail);
        yayinevi.setYayineviTelefon(yayineviTelefon);

        return yayineviDao.yayineviEkleGuncelle(yayinevi);

    }


}
