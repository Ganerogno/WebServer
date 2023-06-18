package com.example.test.Controllers;

import com.example.test.Entities.Product;
import com.example.test.Requests.ProductRequest;
import com.example.test.Services.StorageService;
import com.example.test.ServicesImpl.ProductServiceImpl;
import com.example.test.ServicesImpl.StorageServiceImpl;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    ProductServiceImpl productService;
    @Autowired
    StorageServiceImpl storageService;

    @GetMapping("/addProduct")
    public ModelAndView addProductPage(){
        ModelAndView modelAndView = new ModelAndView("addProduct");
        modelAndView.addObject("request",new ProductRequest());
        return modelAndView;
    }
    @PostMapping(value = "/addProduct", consumes = MULTIPART_FORM_DATA_VALUE)
    public void addProductAction(@ModelAttribute("request") ProductRequest request,
                                 HttpServletResponse response) throws IOException {


        try{
            Product product = Product.builder().
                    name(request.getName())
                    .description(request.getDescription())
                    .price(request.getPrice())
                    .URI("uploads/" + request.getFile().getOriginalFilename())
                    .build();
            storageService.save(request.getFile());
            productService.add(product);
        } catch (IOException e){
            e.printStackTrace();
        }

//        productService.add(product);
//

        response.sendRedirect("/home");
    }
    @GetMapping(value="/deleteImages")
    public void deleteImages(HttpServletResponse response) throws IOException{
        storageService.deleteAll();
        response.sendRedirect("/home");
    }
}
