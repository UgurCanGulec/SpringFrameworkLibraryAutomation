package com.kutuphanetakip.dao;

import com.gulecugurcan.config.AppConfig;
import com.gulecugurcan.config.WebConfig;
import com.gulecugurcan.dao.YayineviDao;
import com.gulecugurcan.model.Yayinevi;
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
public class TestYayineviDao {
    @Autowired
    private YayineviDao yayineviDao;

    @Test
    @Rollback(value = false)
    public void testYayineviEkleGuncelle(){
        Yayinevi yayinevi=new Yayinevi();
        yayinevi.setYayineviID(15L);
        yayinevi.setYayineviAdi("Kum Yayinevi");
        yayinevi.setYayineviSehri("Esenyurt/İstanbul");
        yayinevi.setYayineviMail("kumbooks@gmail.com");
        yayinevi.setYayineviTelefon("(0212) 654 26 00");
        boolean success=yayineviDao.yayineviEkleGuncelle(yayinevi);
        Assert.assertTrue(success);
    }
    @Test
    public void testYayineviListele(){
        List<Yayinevi> yayineviList=yayineviDao.yayineviListele();
        Assert.assertTrue(yayineviList.size()>0);
    }
    @Test
    @Rollback(value = false)
    public void testYayineviSil(){
        Yayinevi yayinevi=new Yayinevi();
        yayinevi.setYayineviID(12L);
        yayinevi.setYayineviAdi("Pegasus Yayinevi");
        yayinevi.setYayineviSehri("Beyoglu/İstanbul");
        yayinevi.setYayineviMail("pegasusbooks@gmail.com");
        yayinevi.setYayineviTelefon("(0212) 244 23 50");

        yayineviDao.yayineviEkleGuncelle(yayinevi);
        yayineviDao.yayineviSil(yayinevi);

        Yayinevi dbYayinevi=(Yayinevi) yayineviDao.yayineviGetir(Yayinevi.class,12L);
        Assert.assertNull(dbYayinevi);
    }
}
