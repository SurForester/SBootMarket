package ru.gb.sbootmarket.repository;

import org.springframework.stereotype.Component;
import ru.gb.sbootmarket.entity.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class ProductsRepository {

    private List<Product> productList;

    private AtomicLong identity = new AtomicLong(2);

    public ProductsRepository() {
        productList = new ArrayList<>();
        productList.add(new Product(0, "Product1", 11.11F));
        productList.add(new Product(1, "Product2", 22.22F));
    }

    public void addProduct(Product product) {
        if (product.getId()==-1) {
            long id = identity.incrementAndGet();
            product.setId(id);
        }
        productList.add(product);
    }

    public List<Product> findAll() {
        return new ArrayList<>(productList);
    }

    public Product findProductById(long id) {
        Product p = null;
        for (Product product : productList)
            if (product.getId() == id) {
                p = product;
                break;
            }
        return p;
    }

}
