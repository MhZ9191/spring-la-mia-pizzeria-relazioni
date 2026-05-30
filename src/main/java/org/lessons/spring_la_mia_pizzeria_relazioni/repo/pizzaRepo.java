package org.lessons.spring_la_mia_pizzeria_relazioni.repo;

import org.lessons.spring_la_mia_pizzeria_relazioni.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pizzaRepo extends JpaRepository<Pizza, Integer>{
    
}
