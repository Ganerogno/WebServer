package com.example.test.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private String URI;
    private int price;

    @ManyToMany(mappedBy = "orderedProducts",cascade = CascadeType.ALL)
    private Set<Order> ordersIncludingProducts;
    @ManyToMany(mappedBy="chosenProducts")
    private Set<User> users;
}
