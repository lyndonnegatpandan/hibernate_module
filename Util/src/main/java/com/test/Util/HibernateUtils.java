package com.test.hibernate_modules;
import java.util.Properties;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.File;
// import org.hibernate.service.ServiceRegistry;


public class HibernateUtils {
    

    public static SessionFactory getSessionFactory(){
        //Configuration configuration = new Configuration().configure("Model/src/resources/hibernate.cfg");
        //StandardServiceRegistryBuilder serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        String path = "Model/src/main/resources/hibernate.cfg.xml";
        File file = new File(path);
        SessionFactory sessionFactory = new Configuration().configure(file).buildSessionFactory();
        return sessionFactory;
    }
    
}
