package ru.gb.sbootmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.sbootmarket.dao.ProductsDAO;
import ru.gb.sbootmarket.entity.Product;

import java.util.List;

@Service
public class ProductsService {

    private ProductsDAO productsDAO;

    @Autowired
    public void setProductDAO(ProductsDAO productsDAO) {
        this.productsDAO = productsDAO;
    }

    public Product getProductById(long id) {
        return productsDAO.findById(id);
    }

    public List<Product> getAll() {
        return productsDAO.findAll();
    }

    public void saveOrUpdateProduct(Product product) {
        productsDAO.saveOrUpdate(product);
    }

    public void deleteProduct(Product product) {
        productsDAO.delete(product);
    }

    public void deleteById(long id) {
        productsDAO.deleteById(id);
    }

}
