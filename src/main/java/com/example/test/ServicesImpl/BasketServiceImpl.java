package com.example.test.ServicesImpl;

import com.example.test.Entities.Product;
import com.example.test.Entities.User;
import com.example.test.Repositories.ProductRepository;
import com.example.test.Repositories.UserRepository;
import com.example.test.Services.BasketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public void addProduct(User user, Product product) {

        user.getChosenProducts().add(product);
        System.out.println(product.getName());
        userRepository.save(user);
    }

    @Override
    public void deleteProduct(User user, Product product) {
        user.getChosenProducts().remove(product);
        userRepository.save(user);
    }
}
