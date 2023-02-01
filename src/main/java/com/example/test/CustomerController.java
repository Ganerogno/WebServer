package com.example.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CustomerController {
    CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @RequestMapping("/customers")
    String AllCustomers()
    {
        return "index";
    }
}
