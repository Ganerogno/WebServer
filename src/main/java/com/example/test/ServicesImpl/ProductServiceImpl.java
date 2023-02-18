package com.example.test.ServicesImpl;

import com.example.test.Entities.Product;
import com.example.test.Repositories.ProductRepository;
import com.example.test.Services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;
    @Override
    public void Add(Product customer){
        productRepository.save(customer);
    }
    @Override
    public void Delete(Long id){
        productRepository.deleteById(id);
    }
    @Override
    public Product FindById(Long id){
        return productRepository.findById(id).get();
    }
    @Override
    public List<Product> FindAll(){
        return productRepository.findAll().stream().toList();
    }
    public List<Product> FindByCategory(){return null;}//temp
}
