package com.stein.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
