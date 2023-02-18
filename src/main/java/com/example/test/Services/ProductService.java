package com.example.test.Services;

import com.example.test.Entities.Product;
import java.util.List;
public interface ProductService {
    void Add(Product product);
    void Delete(Long id);
    Product FindById(Long id);
    List<Product> FindAll();
    List<Product> FindByCategory();
}
