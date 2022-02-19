package com.example.briz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/")
    public String pageIndex(Model model){
        return "index";
    }

    @GetMapping("/about")
    public String pageAbout(Model model){
        return "about";
    }

}
