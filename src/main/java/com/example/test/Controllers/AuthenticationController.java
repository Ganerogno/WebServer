package com.example.test.Controllers;

import com.example.test.Authentication.AuthenticationRequest;
import com.example.test.Authentication.AuthenticationResponse;
import com.example.test.Authentication.RegisterRequest;
import com.example.test.Entities.User;
import com.example.test.Services.AuthenticationService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
//    @PostMapping("/registration")
//    public String SaveUser(@ModelAttribute("user") User user, Model model){
//        if(!user.getPassword().equals(user.getPasswordConfirm())) {
//            model.addAttribute("passwordError",
//                    "Пароли не совпадают");
//            return "registration";
//        }
//        if(!userService.save(user)) {
//            model.addAttribute("usernameError",
//                    "Пользователь с таким именем уже существует");
//            return "registration";
//        }
//        return "redirect:/";
//    }
    private final AuthenticationService authenticationService;
    @GetMapping("/registration")
    public Model UserRegister(Model model){
        return model.addAttribute("request", new RegisterRequest());
    }
    @PostMapping("/registration")
    public ResponseEntity<AuthenticationResponse>register(
            @ModelAttribute("request") RegisterRequest request){
        return ResponseEntity.ok(authenticationService.register(request));
    }
    @GetMapping("/login")
    public Model UserLogin(Model model){
        System.out.println("hi");
        return model.addAttribute("request", new AuthenticationRequest());
    }
    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse>authenticate(
            @ModelAttribute("request") AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
