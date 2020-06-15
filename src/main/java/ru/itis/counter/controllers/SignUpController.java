package ru.itis.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.itis.counter.forms.SignUpForm;
import ru.itis.counter.services.SignUpService;

@Controller
public class SignUpController {

    private final SignUpService signUpService;

    public SignUpController(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping("/signUp")
    public String getSignUpPage() {
        return "signUp";
    }

    @PostMapping("/newUser")
    private String signUp(@ModelAttribute("form") SignUpForm form) {
        signUpService.signUp(form);
        return "redirect:/signIn";
    }
}
