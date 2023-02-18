package com.example.test.Controllers;

import com.example.test.Entities.Customer;
import com.example.test.Services.CustomerService;
import com.example.test.ServicesImpl.CustomerServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    CustomerServiceImpl customerService;
    public CustomerController(CustomerServiceImpl customerService){
        this.customerService = customerService;
    }
    @ResponseBody
    @RequestMapping("/customers")
    public ModelAndView AllCustomers() {
        ModelAndView modelAndView = new ModelAndView("customers");
        modelAndView.addObject("customers", customerService.FindAll());
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
        customerService.Add(customer);
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject(customer);
        return modelAndView;
    }

}
