package com.example.test.ServicesImpl;

import com.example.test.Entities.Order;
import com.example.test.Repositories.OrderRepository;
import com.example.test.Services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository repository;
    @Override
    public void add(Order order) {
        repository.save(order);
    }

    @Override
    public void delete(Order order) {
        repository.delete(order);
    }


    @Override
    public void changeStatus(Order order, boolean status) {

    }@Override
    public Order findById(Long id){
        return repository.findById(id).get();
    }
    @Override
    public List<Order> findByUserId(Long id){
        return repository.findAllByUserId(id);
    }
}
