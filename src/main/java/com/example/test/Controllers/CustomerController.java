package com.example.test.Controllers;

import com.example.test.Entities.Customer;
import com.example.test.Repositories.CustomerRepository;
import com.example.test.Repositories.ProductRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
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
    @ResponseBody
    @RequestMapping("/registration")
    public ModelAndView CustomerRegister(){
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }
    @ResponseBody
    @PostMapping("/save")
    public ModelAndView SaveCustomer(@ModelAttribute("customer") Customer customer){
        System.out.println(customer);
        customerRepository.save(customer);
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject(customer);
        return modelAndView;
    }

}
