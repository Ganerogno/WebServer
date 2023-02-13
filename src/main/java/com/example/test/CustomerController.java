package com.example.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CustomerController {
    CustomerRepository customerRepository;
    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }
    @ResponseBody
    @RequestMapping("/customers")
    public ModelAndView AllCustomers() {
        ModelAndView modelAndView = new ModelAndView("customers");
        modelAndView.addObject("customers", customerRepository.findAll().stream().toList());
        return modelAndView;
    }
}
