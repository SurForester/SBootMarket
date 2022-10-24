package ru.gb.sbootmarket.dao;

import org.hibernate.Session;
import org.springframework.stereotype.Component;
import ru.gb.sbootmarket.entity.Buyer;

import java.util.List;

@Component
public class BuyerDAO {

    private final MarketSessionFactory marketSessionFactory;

    public BuyerDAO(MarketSessionFactory marketSessionFactory) {
        this.marketSessionFactory = marketSessionFactory;
    }

    public MarketSessionFactory getMarketSessionFactory() {
        return  marketSessionFactory;
    }

    public List<Buyer> findAll() {
        try(Session session = marketSessionFactory.getSession()) {
            session.beginTransaction();
            List<Buyer> list = (List<Buyer>) session.createQuery("from Buyer").getResultList();
            session.getTransaction().commit();
            return list;
        }
    }

    public Buyer findBuyerById(long id) {
        try(Session session = marketSessionFactory.getSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            return buyer;
        }
    }

}
