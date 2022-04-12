package com.javamsdt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String goHome() {
        System.out.println("Home Page");
        return "index";
    }

    @GetMapping("/")
    public String homePage() {
        System.out.println("Home Page");
        return "index";
    }
}
