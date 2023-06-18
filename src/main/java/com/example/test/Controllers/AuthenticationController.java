package com.example.test.Controllers;

import com.example.test.Requests.AuthenticationRequest;
import com.example.test.Requests.RegisterRequest;
import com.example.test.Services.AuthenticationService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @GetMapping("/registration")
    public Model UserRegister(Model model){
        return model.addAttribute("request", new RegisterRequest());
    }
    @PostMapping("/registration")
    public void register(
            @ModelAttribute("request") RegisterRequest request,
            HttpServletResponse response) throws IOException {
        authenticationService.register(request);
        response.sendRedirect("/login");
    }
    @GetMapping("/login")
    public Model UserLogin(Model model){
        return model.addAttribute("request", new AuthenticationRequest());
    }
    @PostMapping("/login")
    public void authenticate (
            @ModelAttribute("request") AuthenticationRequest request,
            HttpServletResponse response) throws IOException {
        Cookie cookie = new Cookie("jwt", authenticationService.authenticate(request).getToken());
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        authenticationService.authenticate(request);
    }
    @GetMapping("passwordRecovery")
    public Model changePassword(Model model){return model.addAttribute("request", new AuthenticationRequest());}
}
