package com.kutuphanetakip.service;

import com.gulecugurcan.config.AppConfig;
import com.gulecugurcan.config.WebConfig;
import com.gulecugurcan.model.Yayinevi;
import com.gulecugurcan.service.YayineviService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class, AppConfig.class})
@Transactional
@WebAppConfiguration
public class TestYayineviService {
    @Autowired
    private YayineviService yayineviService;

    @Test
    @Rollback(value = true)
    public void testYayineviEkleGuncelle() {
        Yayinevi yayinevi = new Yayinevi();

        boolean success = yayineviService.yayineviEkleGuncelle(yayinevi.setYayineviID(9L),
                yayinevi.setYayineviAdi("Deneme Yayinevi"),
                yayinevi.setYayineviSehri("Beyoglu/İstanbul"),
                yayinevi.setYayineviMail("denemebooks@gmail.com"),
                yayinevi.setYayineviTelefon("(0212) 244 23 50"));

        Assert.assertTrue(success);
    }
    @Test
    public void testYayineviListele(){
        List<Yayinevi> yayineviList=yayineviService.yayineviListele();
        Assert.assertTrue(yayineviList.size()>0);
    }
    @Test
    @Rollback(value = false)
    public void testYayineviSil(){
        Yayinevi yayinevi = new Yayinevi();

         yayineviService.yayineviEkleGuncelle(yayinevi.setYayineviID(8L),
                yayinevi.setYayineviAdi("Kum Yayinevi"),
                yayinevi.setYayineviSehri("Esenyurt/İstanbul"),
                yayinevi.setYayineviMail("kumbooks@gmail.com"),
                yayinevi.setYayineviTelefon("(0212) 654 26 00"));
         yayineviService.yayineviSil(8L);

         Yayinevi yayinevidb=(Yayinevi) yayineviService.yayineviGetirId(8L);
         Assert.assertNull(yayinevidb);

    }
}
