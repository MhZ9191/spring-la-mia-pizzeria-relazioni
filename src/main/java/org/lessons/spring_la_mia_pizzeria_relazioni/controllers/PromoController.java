package org.lessons.spring_la_mia_pizzeria_relazioni.controllers;

import org.lessons.spring_la_mia_pizzeria_relazioni.entities.Promo;
import org.lessons.spring_la_mia_pizzeria_relazioni.repo.promoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/promo")
public class PromoController {
    
    @Autowired
    private promoRepo repo;

    @PostMapping("/create")
    public String store( @Valid @ModelAttribute Promo newPromo, BindingResult bindingResult, Model model) {
        
        if(bindingResult.hasErrors()){
            return "promos/create";
        }

        repo.save(newPromo);
        return "redirect:/";
    }
    
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable Integer id,Model model) {
        model.addAttribute(repo.findById(id).get());
        model.addAttribute("edit",true);
        return "promos/create";
    }
    
    @PostMapping("/{id}/edit")
    public String update(@Valid @ModelAttribute Promo upPromo, BindingResult bindingResult, Model model) {
        
        if(bindingResult.hasErrors()){
            return "promos/create";
        }

        repo.save(upPromo);

        return "redirect:/";
    }
    
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Integer id,Model model) {
        repo.delete(repo.findById(id).get());
        return "redirect:/";
    }
    

}
