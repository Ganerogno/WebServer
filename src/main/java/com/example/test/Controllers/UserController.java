package com.example.test.Controllers;

import com.example.test.Entities.User;
import com.example.test.ServicesImpl.UserServiceImpl;
import com.example.test.ServicesImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ProductServiceImpl productService;

    @ResponseBody
    @RequestMapping("/users")
    public ModelAndView AllUsers() {
        ModelAndView modelAndView = new ModelAndView("users");
        modelAndView.addObject("user", userService.findAll());
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
