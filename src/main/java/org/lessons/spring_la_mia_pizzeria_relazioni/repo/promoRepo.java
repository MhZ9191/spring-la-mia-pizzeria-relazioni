package org.lessons.spring_la_mia_pizzeria_relazioni.repo;

import org.lessons.spring_la_mia_pizzeria_relazioni.entities.Promo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface promoRepo extends JpaRepository<Promo, Integer>{
    
}
