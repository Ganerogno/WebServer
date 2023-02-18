package com.example.test.Services;

import com.example.test.Entities.Customer;
import java.util.List;

public interface CustomerService {
    void Add(Customer customer);
    void Delete(Long id);
    Customer FindById(Long id);
    List<Customer> FindAll();
}
