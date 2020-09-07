package com.gulecugurcan.dao;

import com.gulecugurcan.model.Kitap;
import com.gulecugurcan.model.Yayinevi;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

@Repository
public class KitapDao {
    @Autowired
    private SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    public boolean kitapSil(Object object) {
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");

        boolean success = true;
        try {

            getCurrentSession().remove(object);

        } catch (Exception e) {

            e.printStackTrace();
            success = false;
        }

        return success;
    }

    public List<Kitap> kitapListele() {

        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Kitap> criteriaQuery = criteriaBuilder.createQuery(Kitap.class);
        Root<Kitap> rootEntry = criteriaQuery.from(Kitap.class);
        CriteriaQuery<Kitap> tum = criteriaQuery.select(rootEntry);
        TypedQuery<Kitap> tumKayitlar = getCurrentSession().createQuery(tum);
        return tumKayitlar.getResultList();

    }

    public Object kitapGetir(Class clazz, Serializable id) {
        return getCurrentSession().get(clazz, id);
    }

    public boolean kitapEkleGuncelle(Object object) {
        boolean success = true;
        try {
            getCurrentSession().save(object);

        } catch (Exception e) {

            getCurrentSession().getTransaction().rollback();
            e.printStackTrace();
            success = false;

        }
        return success;

    }
}
