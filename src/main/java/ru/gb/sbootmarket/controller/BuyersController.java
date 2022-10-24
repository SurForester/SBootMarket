package ru.gb.sbootmarket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.gb.sbootmarket.service.BuyerService;

@Controller
@RequestMapping("/buyers")
public class BuyersController {

    private BuyerService buyerService;

    @Autowired
    public void setBuyerService(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @RequestMapping(value = {"/"}, method = RequestMethod.GET)
    public String viewBuyersList(Model model) {
        model.addAttribute("name", "(Полный список)");
        model.addAttribute("buyers", buyerService.getAll());
        return "buyers/list";
    }

    @RequestMapping("/products/{id}")
    public String processForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("name", buyerService.getBuyerById(id).getName());
        model.addAttribute("buyed_products", buyerService.getProdByBuyerId(id));
        return "redirect:/buyers/products";
    }
}
