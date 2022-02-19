package com.example.briz.controller;

import com.example.briz.model.Group;
import com.example.briz.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class GroupController {
    @Autowired
    private GroupRepository groupRepository;

//    @GetMapping("/student")
//    public String see(Model model){
//        return "student";
//    }
}
