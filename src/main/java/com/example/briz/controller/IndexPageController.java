package com.example.briz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexPageController {

    @GetMapping("/")
    public String pageIndex(Model model){
        return "index";
    }

    @GetMapping("/about")
    public String pageAbout(Model model){
        return "about";
    }

    @GetMapping("/page-except")
    public String pageException(Model model){
        return "page-except";
    }

}
