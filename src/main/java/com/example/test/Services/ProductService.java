package com.example.test.Services;

import com.example.test.Entities.Product;
import java.util.List;
public interface ProductService {
    void add(Product product);
    void delete(Long id);
    Product findById(Long id);
    Product findByName(String name);
    List<Product> findAll();
}
