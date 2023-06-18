package com.example.test.Controllers;

import com.example.test.Entities.Product;
import com.example.test.Repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {

    ProductRepository productRepository;
    ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

//    @ResponseBody
//    @GetMapping("/addProduct")
//    public ModelAndView AddProduct(){
//        Product product = new Product("apple");
//        ModelAndView modelAndView = new ModelAndView("addProduct");
//        productRepository.save(product);
//        return modelAndView;
//    }
}
