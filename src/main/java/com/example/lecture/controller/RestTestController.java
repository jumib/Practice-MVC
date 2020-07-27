package com.example.lecture.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestTestController {
    @RequestMapping("/test")
    public String test() {
        return "Spring test check";
    }
}


