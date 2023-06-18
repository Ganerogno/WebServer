package com.example.test.Controllers;

import com.example.test.Entities.Order;
import com.example.test.Entities.Product;
import com.example.test.Entities.User;
import com.example.test.Responses.OrderResponse;
import com.example.test.Responses.ProductResponse;
import com.example.test.Services.BasketService;
import com.example.test.Services.OrderService;
import com.example.test.Services.StorageService;
import com.example.test.ServicesImpl.UserServiceImpl;
import com.example.test.ServicesImpl.ProductServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ProductServiceImpl productService;
    @Autowired
    StorageService storageService;
    @Autowired
    BasketService basketService;
    @Autowired
    OrderService orderService;

//    @ResponseBody
//    @RequestMapping("/users")
//    public ModelAndView allUsers() {
//        ModelAndView modelAndView = new ModelAndView("users");
//        modelAndView.addObject("user", userService.findAll());
//        return modelAndView;
//    }

    @ResponseBody
    @RequestMapping("/{id}/products")
    public ModelAndView findAllProduct(){
        ModelAndView modelAndView = new ModelAndView("products");
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
//    @ResponseBody
//    @RequestMapping("/passwordRecovery")
//    public ModelAndView passwordRecovery(){
//        ModelAndView modelAndView = new ModelAndView("passwordRecovery");
//        return modelAndView;
//    }
    @ResponseBody
    @RequestMapping("/ordersHistory")
    public Model ordersHistory(Model model) throws IOException{
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(securityContext != null){
            User user = userService.findByName(
                    securityContext.getAuthentication().getName());
            List<Order> orders = orderService.findByUserId(user.getId());
            List<OrderResponse> responses = new ArrayList<>();
            for(Order order : orders){
                responses.add(OrderResponse.builder()
                                .date(order.getDate().toString())
                                .address(order.getAddress())
                                .userName(user.getName())
                                .description(order.getDescription())
                                .orderedProducts(ProductResponse.getResponseList(
                                        order.getOrderedProducts(), storageService
                                ))
                                .count(order.getOrderedProducts().size())
                                .build());
            }
            model.addAttribute("orders", responses);
        }
        return model;
    }
    @GetMapping("/orderMessage")
    public Model orderMessage(Model model){
        return model;
    }
    @PostMapping("/orderMenu")
    public void saveOrder(Model model, HttpServletResponse response,
                          @ModelAttribute("address") String address,
                          @ModelAttribute("description") String description) throws IOException{
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(securityContext != null){
            User user = userService.findByName(
                    securityContext.getAuthentication().getName());
            List<Product> products = user.getChosenProducts();
            int totalCost = 0;
            for(Product product : products){
                totalCost += product.getPrice();
            }
            if(products.size() != 0){
                Order order = Order.builder()
                        .address(address)
                        .description(description)
                        .user(user)
                        .orderedProducts(products.stream().toList())//Новый список создан специально
                        .totalCost(totalCost)
                        .build();
                orderService.add(order);
            }
            else {

            }
        }


        response.sendRedirect("/orderMessage");
    }
    @GetMapping("/orderMenu")
    public Model getOrder(Model model) throws IOException{
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(securityContext != null){
            User user = userService.findByName(securityContext.getAuthentication().getName());
            List<Product> products = user.getChosenProducts();
            List<ProductResponse> responses = ProductResponse.
                    getResponseList(products , storageService);
            int totalCost = 0;
            for(Product product : products){
                totalCost += product.getPrice();
            }
            model.addAttribute("user", user);
            model.addAttribute("products",responses);
            model.addAttribute("count",responses.size());
            model.addAttribute("totalCost",totalCost);
        }

        return model;
    }
    @GetMapping(value = "basket", produces = MediaType.IMAGE_JPEG_VALUE)
    public Model getBasket(Model model) throws IOException{
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(securityContext!=null){
            User user = userService.findByName(securityContext.getAuthentication().getName());
            List<Product> products = user.getChosenProducts();
            List<ProductResponse> responses = ProductResponse.
                    getResponseList(products, storageService);
            int totalCost = 0;
            for(Product product : products){
                totalCost += product.getPrice();
            }
            model.addAttribute("products",responses);
            model.addAttribute("count",products.size());
            model.addAttribute("totalCost",totalCost);
        }
        return  model;
    }
    @GetMapping(value = "/home", produces = MediaType.IMAGE_JPEG_VALUE)
    public Model home(Model model, Authentication authentication) throws IOException {
        if(authentication!=null){
            List<String> authorities = authentication.getAuthorities()
                    .stream()
                    .map(scope -> scope.toString())
                    .collect(Collectors.toList());
            model.addAttribute("authorities",authorities);
        }
        List<Product>  products = productService.findAll();
        List<ProductResponse> responses = ProductResponse.getResponseList(products, storageService);

        model.addAttribute("products", responses);
        return model;
    }
    @PostMapping("/selectProduct")
    public void selectProduct(@ModelAttribute("productName") String productName,
                              HttpServletResponse response) throws  IOException{
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(securityContext.getAuthentication()!=null)
        {
            basketService.addProduct(userService.findByName(
                            securityContext.getAuthentication().getName()),
                    productService.findByName(productName));
        }
        response.sendRedirect("/home");
    }
    @PostMapping("/deleteProduct")
    public void deleteProduct(@ModelAttribute("productName") String productName,
                              HttpServletResponse response) throws  IOException{
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(securityContext.getAuthentication()!=null)
        {
            basketService.deleteProduct(userService.findByName(
                    securityContext.getAuthentication().getName()),
                    productService.findByName(productName));
        }
        response.sendRedirect("/basket");
    }
}
