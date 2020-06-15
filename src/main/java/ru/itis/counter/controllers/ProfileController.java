package ru.itis.counter.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.counter.dto.UserDto;
import ru.itis.counter.security.details.UserDetailsImpl;

@Controller
public class ProfileController {

    @GetMapping("/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                 Model model) {
        model.addAttribute("user", UserDto.get(userDetails.getUser()));
        return "profile";
    }
}
