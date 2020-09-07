package com.gulecugurcan.dao;


import com.gulecugurcan.model.Yayinevi;
import com.gulecugurcan.service.YayineviService;
import org.apache.log4j.PropertyConfigurator;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

@Repository
public class YayineviDao {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    private static final Logger log = Logger.getLogger(YayineviDao.class.getName());


    public boolean yayineviSil(Object object) {
        PropertyConfigurator.configure("C:\\Users\\Lenovo\\Desktop\\İleri Java Pogramlama Güncel\\SpringKutuphaneProjesi\\src\\main\\resources\\log4j.properties");

        boolean success = true;
        try {
            log.info("Silme kaydi basarili");
            getCurrentSession().remove(object);

        } catch (Exception e) {
            log.warning("Silme Basarisiz "+e.getMessage());
            e.printStackTrace();
            success = false;
        }

        return success;
    }

    public List<Yayinevi> yayineviListele() {

        CriteriaBuilder criteriaBuilder = getCurrentSession().getCriteriaBuilder();
        CriteriaQuery<Yayinevi> criteriaQuery = criteriaBuilder.createQuery(Yayinevi.class);
        Root<Yayinevi> rootEntry = criteriaQuery.from(Yayinevi.class);
        CriteriaQuery<Yayinevi> tum = criteriaQuery.select(rootEntry);
        TypedQuery<Yayinevi> tumKayitlar = getCurrentSession().createQuery(tum);
        return tumKayitlar.getResultList();

    }

    public Object yayineviGetir(Class clazz, Serializable id) {
        return getCurrentSession().get(clazz, id);
    }

    public boolean yayineviEkleGuncelle(Object object) {
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
