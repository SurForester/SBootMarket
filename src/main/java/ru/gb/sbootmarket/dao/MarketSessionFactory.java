package ru.gb.sbootmarket.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.gb.sbootmarket.entity.Buyer;
import ru.gb.sbootmarket.entity.Order;
import ru.gb.sbootmarket.entity.Product;

@Component
public class MarketSessionFactory {

    private final SessionFactory factory;

    {
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Buyer.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();
    }

    public Session getSession() {
        return factory.getCurrentSession();
    }

}
