package com.gulecugurcan.config;

import com.gulecugurcan.dao.KullaniciDao;
import com.gulecugurcan.dao.YayineviDao;
import com.gulecugurcan.model.Kitap;
import com.gulecugurcan.model.Kullanici;
import com.gulecugurcan.model.Yayinevi;
import com.gulecugurcan.service.KullaniciService;
import com.gulecugurcan.service.YayineviService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

import static org.hibernate.cfg.AvailableSettings.*;

@EnableTransactionManagement
@PropertySource(value = "classpath:hibernate.properties",encoding = "UTF-8")
@Configuration
@ComponentScan(basePackages = {"com.gulecugurcan.config"})

public class AppConfig {

    @Autowired
    private Environment environment;
    private  static Logger LOGGER= LoggerFactory.getLogger(AppConfig.class);
    @Bean
    public LocalSessionFactoryBean getSessionFactory(){
        LocalSessionFactoryBean factoryBean=new LocalSessionFactoryBean();

        Properties properties=new Properties();
        properties.put(DRIVER,environment.getProperty("mysql.driver"));
        properties.put(URL,environment.getProperty("mysql.url"));
        properties.put(USER,environment.getProperty("mysql.user"));
        properties.put(PASS,environment.getProperty("mysql.password"));

        //----------------YUKARISI JDBC AYARLARI-------------------------------

        properties.put(SHOW_SQL,environment.getProperty("hibernate.show_sql"));
        properties.put(HBM2DDL_AUTO,environment.getProperty("hibernate.hbm2ddl.auto"));
        properties.put(DIALECT,environment.getProperty("hibernate.dialect"));


        //-----------------------YUKARISI HIBERNATE AYARLARI------------------------

        properties.put(C3P0_MIN_SIZE,environment.getProperty("hibernate.c3p0.min_size"));
        properties.put(C3P0_MAX_SIZE,environment.getProperty("hibernate.c3p0.max_size"));
        properties.put(C3P0_ACQUIRE_INCREMENT,environment.getProperty("hibernate.c3p0.acquire_increment"));
        properties.put(C3P0_TIMEOUT,environment.getProperty("hibernate.c3p0.timeout"));
        properties.put(C3P0_MAX_STATEMENTS,environment.getProperty("hibernate.c3p0.max_statements"));
        properties.put(C3P0_CONFIG_PREFIX+".initialPoolSize",environment.getProperty("hibernate.c3p0.initialPoolSize"));

        factoryBean.setHibernateProperties(properties);
        factoryBean.setAnnotatedClasses(Kullanici.class, Yayinevi.class, Kitap.class);//Model sınıfları araya virgül at devam et
        return factoryBean;


    }

    @Bean
    public HibernateTransactionManager getTransactionManager(){

        HibernateTransactionManager transactionManager=new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;


    }

    @Bean
    public YayineviDao getYayineviDao(){
        return new YayineviDao();
    }
    @Bean
    public YayineviService getYayineviService(){
        return new YayineviService();
    }
    @Bean
    public KullaniciService getKullaniciService(){
        return new KullaniciService();
    }
    @Bean
    public KullaniciDao getKullaniciDao(){
        return new KullaniciDao();
    }



}
