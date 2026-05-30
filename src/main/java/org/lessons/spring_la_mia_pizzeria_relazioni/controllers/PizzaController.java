package org.lessons.spring_la_mia_pizzeria_relazioni.controllers;

import org.lessons.spring_la_mia_pizzeria_relazioni.repo.pizzaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/")
public class PizzaController {
    
    @Autowired
    private pizzaRepo repo;

    @GetMapping
    public String homePage(Model model) {
        model.addAttribute("pizzas",repo.findAll());
        return "index";
    }
    
    

}
