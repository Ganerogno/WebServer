package com.example.test.Services;

import com.example.test.Entities.Order;

import java.util.List;

public interface OrderService {
    void add(Order order);
    void delete(Order order);
    void changeStatus(Order order, boolean status);
    Order findById(Long id);
    List<Order> findByUserId(Long id);
}
