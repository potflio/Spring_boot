package com.example.ajax_api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class viewcontroller {
    @GetMapping
    public String form(){
        return "form";
    }
}
