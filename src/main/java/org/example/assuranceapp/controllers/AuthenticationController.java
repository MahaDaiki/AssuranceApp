package org.example.assuranceapp.controllers;

import org.example.assuranceapp.models.Utilisateur;
import org.example.assuranceapp.service.serviceInterface.AuthenticationServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthenticationController {

@Autowired
    private AuthenticationServiceInt authenticationService;

@PostMapping("/register")
    public String register(@RequestAttribute Utilisateur utilisateur) {
    if (authenticationService.Register(utilisateur)) {
        return "Registration successful!";
    } else {
        return "Registration failed!";
    }
}
    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password) {
        if (authenticationService.Login(email, password)) {
            return "Login successful!";
        } else {
            return "Invalid credentials!";
        }
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        authenticationService.logout(session);
        return "Logout successful!";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("utilisateur", new Utilisateur());
        return "register";

    }

    @GetMapping("/login")
    public String login(Model model) {
    return "login";
    }
}
