package ru.gb.sbootmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.sbootmarket.dao.MarketSessionFactory;
import ru.gb.sbootmarket.dao.OrderDAO;
import ru.gb.sbootmarket.entity.Buyer;
import ru.gb.sbootmarket.entity.Order;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private OrderDAO orderDAO;

    public OrderService(MarketSessionFactory marketSessionFactory) {
        if (orderDAO == null) {
            orderDAO = new OrderDAO(marketSessionFactory);
        }
    }

    @Autowired
    public void setOrderDAO(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public List<String> getBuyersByProductId(long id) {
        List<String> list = new ArrayList<>();
        for (Order order : orderDAO.getOrderByProductId(id)) {
            list.add(order.getBuyer().toString());
        }
        return list;
    }

    public List<String> getProductsByBuyerId(long id) {
        List<String> list = new ArrayList<>();
        for (Order order : orderDAO.getOrdersByBuyerId(id)) {
            list.add(order.getProduct().toString());
        }
        return list;
    }

    public List<String> getProductsByBuyer(Buyer buyer) {
        List<String> list = new ArrayList<>();
        for (Order order : orderDAO.getOrdersByBuyer(buyer)) {
            list.add(order.getProduct().toString());
        }
        return list;
    }
}
