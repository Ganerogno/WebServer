package com.example.test.Controllers;

import com.example.test.Entities.Customer;
import com.example.test.ServicesImpl.CustomerServiceImpl;
import com.example.test.ServicesImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {
    @Autowired
    CustomerServiceImpl customerService;
    @Autowired
    ProductServiceImpl productService;

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

    @ResponseBody
    @RequestMapping("/{id}/products")
    public ModelAndView FindAllProduct(){
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productService.FindAll());
        return modelAndView;
    }

}
