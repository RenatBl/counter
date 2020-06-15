package ru.itis.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.counter.forms.SignUpForm;
import ru.itis.counter.services.SignUpService;

@Controller
public class AuthorizationController {

    private final SignUpService signUpService;

    public AuthorizationController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/newUser")
    public String signUp(@ModelAttribute("form") SignUpForm form) {
        signUpService.signUp(form);
        return "redirect:/login";
    }
}
