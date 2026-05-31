package org.lessons.spring_la_mia_pizzeria_relazioni.entities;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name="promos")
public class Promo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn( name="pizza_id", nullable = false)
    private Pizza pizza;

    @NotBlank
    private String title;

    @PastOrPresent(message="La data non può iniziare nel passato")
    private LocalDate start;   

    @PastOrPresent(message="La data non può finire nel passato")
    private LocalDate end;

    //GETTERS

    public Pizza getPizza(){
        return this.pizza;
    }

    public void setPizza(Pizza pizza){
        this.pizza=pizza;
    }

    public Integer getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public LocalDate getStart(){
        return this.start;
    }

    public LocalDate getEnd(){
        return this.end;
    }

    //SETTERS

    public void setId(Integer id){
        this.id=id;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setStart(LocalDate start){
        this.start=start;
    }

    public void setEnd(LocalDate end){
        this.end=end;
    }

}
