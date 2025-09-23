package com.collegemgmt.College.Management.System.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        // Serve the static page from src/main/resources/static/Main.html
        return "redirect:/Main.html";
    }
}
