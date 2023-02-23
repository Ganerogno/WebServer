package com.example.test.Controllers;

import com.example.test.Entities.User;
import com.example.test.ServicesImpl.UserServiceImpl;
import com.example.test.ServicesImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
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
        modelAndView.addObject("user", userService.FindAll());
        return modelAndView;
    }
    @ResponseBody
    @RequestMapping("/registration")
    public ModelAndView UserRegister(){
        ModelAndView modelAndView = new ModelAndView("registration");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }
    @ResponseBody
    @PostMapping("/save")
    public ModelAndView SaveUser(@ModelAttribute("user") User user){
        userService.Add(user);
        ModelAndView modelAndView = new ModelAndView("welcome");
        modelAndView.addObject(user);
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
