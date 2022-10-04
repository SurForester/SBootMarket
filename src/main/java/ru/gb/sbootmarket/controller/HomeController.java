package ru.gb.sbootmarket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

    @RequestMapping(value = { "/" }, method = RequestMethod.GET)
    public String index(Model model) {
        String message = "Sample Spring Boot + JSP project.";
        model.addAttribute("message", message);
        return "index";
    }

}
