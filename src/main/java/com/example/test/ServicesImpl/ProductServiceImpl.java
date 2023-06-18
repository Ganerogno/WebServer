package com.example.test.ServicesImpl;

import com.example.test.Entities.Product;
import com.example.test.Repositories.ProductRepository;
import com.example.test.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Override
    public void add(Product customer){
        productRepository.save(customer);
    }
    @Override
    public void delete(Long id){
        productRepository.deleteById(id);
    }
    @Override
    public Product findById(Long id){
        return productRepository.findById(id).get();
    }

    @Override
    public Product findByName(String name) {
        return productRepository.findByName(name).get();
    }

    @Override
    public List<Product> findAll(){
        return productRepository.findAll().stream().toList();
    }
}
