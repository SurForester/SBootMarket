package ru.gb.sbootmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.sbootmarket.entity.Product;
import ru.gb.sbootmarket.service.ProductsService;

@Controller
@RequestMapping("/products")
public class ProductsController {

    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping(value = {"/", "/list"}, method = RequestMethod.GET)
    public String viewPersonList(Model model) {
        model.addAttribute("name", "(Полный список)");
        model.addAttribute("products", productsService.getAll());
        return "products/list";
    }

    @GetMapping("/add")
    public String addProduct(Model model) {
        Product product = new Product(-1, "", 0);
        model.addAttribute("product", product);
        return "products/add";
    }

    @RequestMapping("/processForm")
    public String processForm(@ModelAttribute("product") Product product) {
        productsService.addProduct(product);
        return "products/add-result";
    }
}
