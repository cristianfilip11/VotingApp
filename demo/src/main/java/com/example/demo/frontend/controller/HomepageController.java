package com.example.demo.frontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomepageController {

    @GetMapping("/homepage")
    public String showLoginPage(){
        return "homepage";
    }


}
