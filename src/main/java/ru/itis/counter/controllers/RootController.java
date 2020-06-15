package ru.itis.counter.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/")
    public String getRoot(Authentication authentication) {
        return authentication == null ? "redirect:/login" : "redirect:/profile";
    }
}
