package com.kutuphanetakip.service;

import com.gulecugurcan.config.AppConfig;
import com.gulecugurcan.config.WebConfig;
import com.gulecugurcan.dao.KullaniciDao;
import com.gulecugurcan.model.Kullanici;
import com.gulecugurcan.service.KullaniciService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class})
@Transactional
@WebAppConfiguration
public class TestKullaniciService {
    @Autowired
    private KullaniciService kullaniciService;
    @Autowired
    private KullaniciDao kullaniciDao;

    @Test
    @Rollback(value = false)
    public void testKullaniciEkleGuncelle(){
        Kullanici kullanici=new Kullanici();
        boolean success = kullaniciService.kullaniciEkleGuncelle(kullanici.setKulllaniciIsimSoyisim("Fatih OzakasapOglu"),
                kullanici.setKullaniciEmail("fatihozkasapoglu@gmail.com"),
                kullanici.setKullaniciParola("1997"),
                kullanici.setKullaniciTelefon("05051402393")

        );
        // boolean success=kullaniciDao.kullaniciEkleGuncelle(kullanici);
        Assert.assertTrue(success);
    }

}
