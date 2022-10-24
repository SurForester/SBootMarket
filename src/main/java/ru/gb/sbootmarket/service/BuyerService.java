package ru.gb.sbootmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.sbootmarket.dao.BuyerDAO;
import ru.gb.sbootmarket.dao.OrderDAO;
import ru.gb.sbootmarket.entity.Buyer;
import ru.gb.sbootmarket.entity.Product;

import java.util.List;

@Service
public class BuyerService {

    private BuyerDAO buyerDAO;

    @Autowired
    public void setBuyerDAO(BuyerDAO buyerDAO) {
        this.buyerDAO = buyerDAO;
    }

    public List<Buyer> getAll() {
        return buyerDAO.findAll();
    }

    public Buyer getBuyerById(long id) {
        return buyerDAO.findBuyerById(id);
    }

    public List<String> getProdByBuyerId(long id) {
        OrderService os = new OrderService(this.buyerDAO.getMarketSessionFactory());
        List<String> list = os.getProductsByBuyerId(id);
        return list;
    }

}
