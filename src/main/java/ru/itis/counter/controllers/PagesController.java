package ru.itis.counter.controllers;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.itis.counter.dto.PageDto;
import ru.itis.counter.security.details.UserDetailsImpl;
import ru.itis.counter.services.PagesService;

@Controller
public class PagesController {

    private final PagesService pagesService;

    public PagesController(PagesService pagesService) {
        this.pagesService = pagesService;
    }

    @GetMapping("/pages")
    public String getAllPages(@AuthenticationPrincipal UserDetailsImpl userDetails,
                              Model model) {
        model.addAttribute("pages", PageDto.get(pagesService.findAll(userDetails.getUser())));
        return "pages";
    }

    @GetMapping("/pages/{id}")
    public String getPage(@PathVariable("id") Long id,
                          Model model) {
        model.addAttribute("page", PageDto.get(pagesService.getOne(id)));
        return "page";
    }

    @PostMapping("/newPage")
    public String newPage(@RequestParam("url") String url,
                          @AuthenticationPrincipal UserDetailsImpl userDetails) {
        pagesService.addNew(url, userDetails.getUser());
        return "redirect:/pages";
    }
}
