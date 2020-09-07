package com.gulecugurcan.dao;

import com.gulecugurcan.model.Kullanici;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.logging.Logger;

@Repository
public class KullaniciDao {
    public Long kulID;

    @Autowired
    SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public Object kullaniciGetir(Class clazz, Serializable id) {
        return getCurrentSession().get(clazz, id);
    }


    public boolean kullaniciEkleGuncelle(Kullanici kullanici) {

        if (kullanici != null) {
            try {
                getCurrentSession().save(kullanici);

                this.kulID = kullanici.getKullaniciID();

            } catch (Exception e) {
                getCurrentSession().getTransaction().rollback();
                e.printStackTrace();

            }
        }
        return true;
    }


}
