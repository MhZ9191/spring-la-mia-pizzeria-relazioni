package org.lessons.spring_la_mia_pizzeria_relazioni.controllers;

import org.lessons.spring_la_mia_pizzeria_relazioni.entities.Pizza;
import org.lessons.spring_la_mia_pizzeria_relazioni.entities.Promo;
import org.lessons.spring_la_mia_pizzeria_relazioni.repo.ingredientRepo;
import org.lessons.spring_la_mia_pizzeria_relazioni.repo.pizzaRepo;
import org.lessons.spring_la_mia_pizzeria_relazioni.repo.promoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;





@Controller
@RequestMapping("/")
public class PizzaController {
    
    @Autowired
    private pizzaRepo repo;

    @Autowired
    private promoRepo promorep;

    @Autowired
    private ingredientRepo ingRepo;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("pizzas",repo.findAll());
        return "index";
    }
    
    @GetMapping("/{id}")
    public String show(@PathVariable Integer id,Model model) {
        model.addAttribute("pizza",repo.findById(id).get());
        return "pizza/detail";
    }
    
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("pizza",new Pizza());
        model.addAttribute("ingredients",ingRepo.findAll());
        return "pizza/create";
    }
    
    @PostMapping("/create")
    public String store(@Valid @ModelAttribute Pizza newPizza , BindingResult bindingResult, Model model) {
        
        if(bindingResult.hasErrors()){
            return "pizza/create";
        }
        repo.save(newPizza);
        return "redirect:/";
    }
    
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("pizza",repo.findById(id).get());
        model.addAttribute("edit",true);
        return "pizza/create";
    }
    
    @PostMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute Pizza updatePizza, BindingResult bindingResult, Model model) {
        
        if(bindingResult.hasErrors()){
            return "pizza/create";
        }
        
        repo.save(updatePizza);

        return "redirect:/";
    }
    
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id) {

        Pizza currentPizza = repo.findById(id).get();

        for(Promo promo : currentPizza.getPromos()){
            promorep.delete(promo);
        }

        repo.delete(currentPizza);

        return "redirect:/";
    }
    
    @GetMapping("/{id}/promo")
    public String createPromo(@PathVariable Integer id, Model model) {
        Promo promo = new Promo();
        Pizza currentPizza = repo.findById(id).get();
        promo.setPizza(currentPizza);
        model.addAttribute("promo",promo);
        return "promos/create";
    }
    
    

}
