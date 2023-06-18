package com.example.test.Services;

import com.example.test.Entities.Product;
import com.example.test.Entities.User;

public interface BasketService {
    void addProduct(User user, Product product);
    void deleteProduct(User user, Product product);
}
