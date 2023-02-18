package com.example.test.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import com.example.test.Categories.Category;
import java.util.Set;

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
}
