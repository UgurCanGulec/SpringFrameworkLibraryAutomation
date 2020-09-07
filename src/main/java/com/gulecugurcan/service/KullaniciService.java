package com.gulecugurcan.service;

import com.gulecugurcan.dao.KullaniciDao;
import com.gulecugurcan.model.Kullanici;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.logging.Logger;


@Service
@Transactional(propagation = Propagation.REQUIRED,readOnly = false,rollbackFor = Exception.class)
public class KullaniciService   {
    @Autowired
    private KullaniciDao kullaniciDao;



    public Boolean kullaniciEkleGuncelle(String isim_soyisim, String email, String parola, String telefon) {

        Kullanici kullanici=new Kullanici();
        kullanici.setKulllaniciIsimSoyisim(isim_soyisim);
        kullanici.setKullaniciEmail(email);
        kullanici.setKullaniciParola(parola);
        kullanici.setKullaniciTelefon(telefon);
        return kullaniciDao.kullaniciEkleGuncelle(kullanici);
    }

    public Long IDGetir(){
        return kullaniciDao.kulID;
    } //Kullanıcıya ID Bilgisini Göstermek Amacıyla

    public Object KullaniciGetir(Long id){ //Giriş işlemi amacıyla
        return kullaniciDao.kullaniciGetir(Kullanici.class,id);
    }


}
