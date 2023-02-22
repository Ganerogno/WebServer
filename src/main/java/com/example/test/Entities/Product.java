package com.example.test.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    //private Set<Category> categories;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Product(){};
    public Product(String name){
        this.name = name;
    }
    @Override
    public boolean equals(Object o)
    {
        if(this == o)
            return true;
        if(!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(this.id, product.id) &&
                Objects.equals(this.name, product.name);
    }
    @Override
    public int hashCode()
    {
        return Objects.hash(this.id, this.name);
    }
    @Override
    public String toString() {
        return "Product{ " + "id=" + this.id +
                ", name="+this.name + " }\n";
    }
}
