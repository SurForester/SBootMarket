package ru.gb.sbootmarket.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.gb.sbootmarket.entity.Buyer;
import ru.gb.sbootmarket.entity.Order;

import java.util.List;

@Component
public class OrderDAO {

    private final MarketSessionFactory marketSessionFactory;

    public OrderDAO(MarketSessionFactory marketSessionFactory) {
        this.marketSessionFactory = marketSessionFactory;
    }

    public List<Order> getOrdersByBuyerId(long id) {
        try (Session session = marketSessionFactory.getSession()) {
            session.beginTransaction();
            List<Order> list = (List<Order>) session
                    .createQuery("from Order o")
                    //.createQuery("from Order o where o.buyer.id = :id")
                    //.setParameter("id", id)
                    .getResultList();
            for (Order order : list) {
                order.getProduct();
            }
            session.getTransaction().commit();
            return list;
        }
    }

    public List<Order> getOrdersByBuyer(Buyer buyer) {
        try (Session session = marketSessionFactory.getSession()) {
            session.beginTransaction();
            List<Order> list = (List<Order>) session
                    //.createQuery("from Order o")
                    .createQuery("from Order o where o.buyer = buyer")
                    .getResultList();
            for (Order order : list) {
                order.getProduct();
            }
            session.getTransaction().commit();
            return list;
        }
    }

    public List<Order> getOrderByProductId(long id) {
        try (Session session = marketSessionFactory.getSession()) {
            session.beginTransaction();
            List<Order> list = (List<Order>) session.createQuery("from Order o where o.product.id = :id")
                    .setParameter("id", id)
                    .getResultList();
            for (Order order : list) {
                order.getBuyer();
            }
            session.getTransaction().commit();
            return list;
        }
    }
}
