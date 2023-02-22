package com.example.test.ServicesImpl;

import com.example.test.Entities.Customer;
import com.example.test.Repositories.CustomerRepository;
import com.example.test.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
//    CustomerServiceImpl(CustomerRepository customerRepository){
//        this.customerRepository = customerRepository;
//    }
    @Override
    public void Add(Customer customer){
        customerRepository.save(customer);
    }
    @Override
    public void Delete(Long id){
        customerRepository.deleteById(id);
    }
    @Override
    public Customer FindById(Long id){
        return customerRepository.findById(id).get();
    }
    @Override
    public List<Customer> FindAll(){
        return customerRepository.findAll().stream().toList();
    }
}
