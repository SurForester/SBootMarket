package ru.gb.sbootmarket.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.gb.sbootmarket.entity.Product;

import java.util.List;

@Component
public class ProductsDAO {

    private final SessionFactoryProducts sessionFactoryProducts;

    public ProductsDAO(SessionFactoryProducts sessionFactoryProducts) {
        this.sessionFactoryProducts = sessionFactoryProducts;
    }

    public List<Product> findAll() {
        try(Session session = sessionFactoryProducts.getSession()) {
            session.beginTransaction();
            List<Product> list = (List<Product>) session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return list;
        }
    }

    public Product findById(long id) {
        try(Session session = sessionFactoryProducts.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }

    public void saveOrUpdate(Product product) {
        try(Session session = sessionFactoryProducts.getSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
        }
    }

    public void delete(Product product) {
        try(Session session = sessionFactoryProducts.getSession()) {
            session.beginTransaction();
            session.delete(product);
            session.getTransaction().commit();
        }
    }

    public void deleteById(long id) {
        try(Session session = sessionFactoryProducts.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.delete(product);
            session.getTransaction().commit();
        }
    }

}
