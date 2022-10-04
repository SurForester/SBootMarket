package ru.gb.sbootmarket.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.gb.sbootmarket.entity.Product;
import ru.gb.sbootmarket.repository.ProductsRepository;

import java.util.List;

@Service
public class ProductsService {

    private ProductsRepository productsRepository;

    public ProductsService() {
    }

    @Autowired
    public void setProductsRepository(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }

    public Product getProductById(long id) {
        return this.productsRepository.findProductById(id);
    }

    public List<Product> getAll() {
        return this.productsRepository.findAll();
    }

    public void addProduct(Product product) {
        productsRepository.addProduct(product);
    }

}
