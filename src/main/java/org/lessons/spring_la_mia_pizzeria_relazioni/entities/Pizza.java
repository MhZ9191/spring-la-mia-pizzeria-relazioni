package org.lessons.spring_la_mia_pizzeria_relazioni.entities;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table( name = "pizzas")
public class Pizza {
    
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToMany(mappedBy = "pizza")
    List<Promo> promos;

    @NotBlank(message="Campo obbligatorio")
    private String name;

    @NotBlank(message="Campo obbligatorio")
    private String description;

    private String image;

    @NotNull
    @DecimalMin(value="0.0", message="Il prezzo deve essere maggiore di 0")
    private BigDecimal price;

    //GETTERS

    public List<Promo> getPromos(){
        return this.promos;
    }

    public void setPromos(List<Promo> promos){
        this.promos=promos;
    }

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public String getImage(){
        return this.image;
    }

    public BigDecimal getPrice(){
        return this.price;
    }

    //SETTERS

    public void setId(Integer id){
        this.id=id;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public void setImage(String image){
        this.image=image;
    }

    public void setPrice(BigDecimal price){
        this.price=price;
    }

}
