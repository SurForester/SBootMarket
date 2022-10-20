package ru.gb.sbootmarket.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.gb.sbootmarket.entity.Product;

@Component
public class SessionFactoryProducts {

    private static SessionFactory factory;

    {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .buildSessionFactory();
    }

    public static Session getSession() {
        return factory.getCurrentSession();
    }

}
