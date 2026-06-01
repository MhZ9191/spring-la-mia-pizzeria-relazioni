package org.lessons.spring_la_mia_pizzeria_relazioni.repo;

import org.lessons.spring_la_mia_pizzeria_relazioni.entities.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ingredientRepo extends JpaRepository<Ingredient,Integer>{
    
}
